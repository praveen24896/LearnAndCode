public class CarbonFootprintCalculator {
    
    public double getInboxCarbonFootprint(EmailEntity entity, boolean hasAttachment, boolean isPhone, boolean isLongMail) {
        double footprint = 0;

        if (hasAttachment) {
            footprint = Constants.AVG_ATTACHMENT_SIZE * Constants.SHORT_EMAIL_RECD_PER_g;
        } else {
            footprint = Constants.MAIL_REC_ON_PHONE;
        }

        if (isLongMail) {
            footprint *= Constants.LONG_EMAIL_RECD_PER_g;
        }
        if (!isPhone) {
            footprint *= Constants.MAIL_REC_ON_LAPTOP;
        }

        return footprint;
    }

    public double getSentCarbonFootprint() {
        return Constants.EMAIL_ENERGY_USAGE_g_cm * Constants.GRID_EMISSIONS_PER_g *
                Constants.DATA_CENTER_EFFICIENCY * Constants.DEVICE_EFFICIENCY;
    }

    public double getSpamCarbonFootprint() {
        return Constants.SPAM_EMAIL_PER_g;
    }
}
