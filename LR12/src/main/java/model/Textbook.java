package model;

public class Textbook extends Book {
    private String subject;

    public Textbook(String title, int id, int pages, String subject) {
        super(title, id, pages);
        this.subject = subject;
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", subject='" + subject + "'}");
    }
}