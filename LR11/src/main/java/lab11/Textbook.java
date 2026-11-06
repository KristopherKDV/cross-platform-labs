package lab11;

public class Textbook extends Book {

    private String subject;

    public Textbook(String title, String author, int pages, String subject) {
        super(title, author, pages);
        this.subject = subject;
    }

    @Override
    public String getGenre() {
        return "Учебник";
    }

    public void read(String chapter, int exercises) {
        System.out.println("Читаю главу \"" + chapter + "\" учебника \""
                + getTitle() + "\" и решаю " + exercises + " упражнений");
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() + " [Textbook{subject='" + subject + "'}]";
    }
}