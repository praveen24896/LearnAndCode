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
        EmailSourceIdentifier sourceIdentifier = new EmailSourceIdentifier();
        EmailService emailService = new EmailService(sourceIdentifier);
        EmailEntity emailEntity = emailService.createEmailEntity(emailId);
        CarbonFootprintCalculator calculator = new CarbonFootprintCalculator();

        double inboxFootprint = calculator.getInboxCarbonFootprint(emailEntity, hasAttachment, isPhone, isLongMail)
                / 1000;
        double sentFootprint = calculator.getSentCarbonFootprint() / 1000;
        double spamFootprint = calculator.getSpamCarbonFootprint() / 1000;

        printEmailData(emailEntity, inboxFootprint, sentFootprint, spamFootprint);
    }

    private static void printEmailData(EmailEntity entity, double inboxFootprint, double sentFootprint,
            double spamFootprint) {
        System.out.println("Email");
        System.out.println("Email ID: " + entity.getEmailId());
        System.out.println("Source: " + entity.getSource());
        System.out.println("Inbox Carbon Footprint: " + inboxFootprint + " KG");
        System.out.println("Sent Carbon Footprint: " + sentFootprint + " KG");
        System.out.println("Spam Carbon Footprint: " + spamFootprint + " KG");
    }
}
