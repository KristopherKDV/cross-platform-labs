package model;

public class Comic extends Book {
    private String illustrator;

    public Comic(String title, int id, int pages, String illustrator) {
        super(title, id, pages);
        this.illustrator = illustrator;
    }

    public String getIllustrator() { return illustrator; }
    public void setIllustrator(String illustrator) { this.illustrator = illustrator; }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", illustrator='" + illustrator + "'}");
    }
}