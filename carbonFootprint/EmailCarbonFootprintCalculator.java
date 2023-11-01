import java.util.Scanner;

public class EmailCarbonFootprintCalculator {
    public static void main(String[] args) {
        boolean hasAttachment = false;
        boolean isPhone = false;
        boolean isLongMail = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Email Address");
        String emailId = sc.nextLine();
        System.out.println("Is there any attachment? (yes/no)");
        String attachmentResponse = sc.nextLine();
        if (attachmentResponse.equalsIgnoreCase("yes")) {
            hasAttachment = true;
        }
        System.out.println("Enter the device on which you are viewing the mail (Phone or Laptop)");
        String device = sc.nextLine();
        if (device.equalsIgnoreCase("phone")) {
            isPhone = true;
        }
        System.out.println("Is the mail long or short? (long/short)");
        String mailType = sc.nextLine();
        if (mailType.equalsIgnoreCase("long")) {
            isLongMail = true;
        }
        sc.close();

        String emailSource = getEmailSourceFromId(emailId);
        EmailEntity emailEntity = new EmailEntity(emailId, emailSource);
        CarbonFootprintCalculator calculator = new CarbonFootprintCalculator();

        double inboxFootprint = calculator.getInboxCarbonFootprint(emailEntity, hasAttachment, isPhone, isLongMail)
                / 1000;
        double sentFootprint = calculator.getSentCarbonFootprint(emailEntity) / 1000;
        double spamFootprint = calculator.getSpamCarbonFootprint(emailEntity) / 1000;

        printEmailData(emailEntity, inboxFootprint, sentFootprint, spamFootprint);
    }

    private static String getEmailSourceFromId(String emailId) {
        if (emailId.contains("@gmail.com")) {
            return "Gmail";
        } else if (emailId.contains("@outlook.com")) {
            return "Outlook";
        } else if (emailId.contains("@yahoo.com")) {
            return "Yahoo";
        } else {
            return "Unknown Source";
        }
    }

    private static void printEmailData(EmailEntity entity, double inboxFootprint, double sentFootprint,
            double spamFootprint) {
        System.out.println("Email (entityType basis)");
        System.out.println("Email ID: " + entity.getEmailId());
        System.out.println("Source: " + entity.getSource());
        System.out.println("Inbox Carbon Footprint: " + inboxFootprint + " KG");
        System.out.println("Sent Carbon Footprint: " + sentFootprint + " KG");
        System.out.println("Spam Carbon Footprint: " + spamFootprint + " KG");
    }
}

class CarbonFootprintCalculator {
    public double getInboxCarbonFootprint(EmailEntity entity, boolean hasAttachment, boolean isPhone,
            boolean isLongMail) {
        double footprint = 0;

        if (hasAttachment && isLongMail && isPhone) {
            footprint = Constants.LONG_EMAIL_AND_ATTACHMENT_PER_g * Constants.MAIL_REC_ON_PHONE;
        } else if (!hasAttachment && isLongMail && isPhone) {
            footprint = Constants.LONG_EMAIL_RECD_PER_g * Constants.MAIL_REC_ON_PHONE;
        } else if (!hasAttachment && !isLongMail && isPhone) {
            footprint = Constants.MAIL_REC_ON_PHONE;
        } else if (hasAttachment && !isLongMail && isPhone) {
            footprint = Constants.AVG_ATTACHMENT_SIZE * Constants.SHORT_EMAIL_RECD_PER_g
                    * Constants.MAIL_REC_ON_PHONE;
        } else if (hasAttachment && !isLongMail && !isPhone) {
            footprint = Constants.AVG_ATTACHMENT_SIZE * Constants.SHORT_EMAIL_RECD_PER_g
                    * Constants.MAIL_REC_ON_LAPTOP;
        } else {
            footprint = Constants.MAIL_REC_ON_LAPTOP;
        }
        return footprint;
    }

    public double getSentCarbonFootprint(EmailEntity entity) {
        return Constants.EMAIL_ENERGY_USAGE_g_cm * Constants.GRID_EMISSIONS_PER_g *
                Constants.DATA_CENTER_EFFICIENCY * Constants.DEVICE_EFFICIENCY;
    }

    public double getSpamCarbonFootprint(EmailEntity entity) {
        return Constants.SPAM_EMAIL_PER_g;
    }
}
