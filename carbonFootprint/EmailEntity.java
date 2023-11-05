public class EmailEntity {
    private String emailId;
    private EmailSource source;

    public EmailEntity(String emailId, EmailSource emailSource) {
        this.emailId = emailId;
        this.source = emailSource;
    }

    public String getEmailId() {
        return emailId;
    }

    public EmailSource getSource() {
        return source;
    }
}