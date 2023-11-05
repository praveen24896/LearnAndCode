public class EmailSourceIdentifier {
    public EmailSource identifySource(String emailId) {
        if (emailId.contains("@gmail.com")) {
            return EmailSource.GMAIL;
        } else if (emailId.contains("@outlook.com")) {
            return EmailSource.OUTLOOK;
        } else if (emailId.contains("@yahoo.com")) {
            return EmailSource.YAHOO;
        } else {
            return EmailSource.UNKNOWN;
        }
    }
}

enum EmailSource {
    GMAIL, OUTLOOK, YAHOO, UNKNOWN
}