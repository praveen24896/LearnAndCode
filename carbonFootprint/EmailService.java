public class EmailService {
    private final EmailSourceIdentifier sourceIdentifier;

    public EmailService(EmailSourceIdentifier sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public EmailEntity createEmailEntity(String emailId) {
        EmailSource source = sourceIdentifier.identifySource(emailId);
        return new EmailEntity(emailId, source);
    }
}