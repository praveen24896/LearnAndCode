
class EmailEntity {
    private String emailId;
    private String source;

    public EmailEntity(String emailId, String emailSource) {
        this.emailId = emailId;
        this.source = emailSource;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getSource() {
        return source;
    }
}

enum EmailSource {
    GMAIL, OUTLOOK, YAHOO
}