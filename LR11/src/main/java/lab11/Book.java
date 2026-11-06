package lab11;

public class Book {

    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void read() {
        System.out.println("Читаю книгу \"" + title + "\"");
    }

    public void read(int pages) {
        System.out.println("Читаю " + pages + " страниц книги \"" + title + "\"");
    }

    public void read(String chapter) {
        System.out.println("Читаю главу \"" + chapter + "\" книги \"" + title + "\"");
    }

    public String getGenre() {
        return "Неизвестный жанр";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{title='" + title
                + "', author='" + author
                + "', pages=" + pages
                + ", genre='" + getGenre() + "'}";
    }
}