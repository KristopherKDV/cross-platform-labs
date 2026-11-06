package model;

import java.util.Objects;

public class Book {
    private String title;
    private int id;
    private int pages;

    public Book(String title, int id, int pages) {
        this.title = title;
        this.id = id;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s{title='%s', id=%d, pages=%d}",
                getClass().getSimpleName(), title, id, pages);
    }
}