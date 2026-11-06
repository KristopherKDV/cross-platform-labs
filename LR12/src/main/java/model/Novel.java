package model;

public class Novel extends Book {
    private String genre;

    public Novel(String title, int id, int pages, String genre) {
        super(title, id, pages);
        this.genre = genre;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", genre='" + genre + "'}");
    }
}