package chap09.entity;

public class Email {

    public Email(int id, String send_email, String receive_email, String title, String content, String attachment, String username) {
        this.id = id;
        this.send_email = send_email;
        this.receive_email = receive_email;
        this.title = title;
        this.content = content;
        this.attachment = attachment;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSend_email() {
        return send_email;
    }

    public void setSend_email(String send_email) {
        this.send_email = send_email;
    }

    public String getReceive_email() {
        return receive_email;
    }

    public void setReceive_email(String receive_email) {
        this.receive_email = receive_email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", send_email='" + send_email + '\'' +
                ", receive_email='" + receive_email + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", attachment='" + attachment + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    private int id;
    private String send_email;
    private String receive_email;
    private String title;
    private String content;
    private String attachment;
    private String username;

}
