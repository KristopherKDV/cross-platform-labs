package lab11;

public class Novel extends Book {

    private String literaryMovement;

    public Novel(String title, String author, int pages, String literaryMovement) {
        super(title, author, pages);
        this.literaryMovement = literaryMovement;
    }

    @Override
    public String getGenre() {
        return "Роман";
    }

    public void read(int pages, String mood) {
        System.out.println("Читаю " + pages + " страниц романа \""
                + getTitle() + "\" с настроением \"" + mood + "\"");
    }

    public String getLiteraryMovement() {
        return literaryMovement;
    }

    @Override
    public String toString() {
        return super.toString() + " [Novel{literaryMovement='" + literaryMovement + "'}]";
    }
}