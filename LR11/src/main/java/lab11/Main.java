package lab11;

public class Main {

    public static void main(String[] args) {

        Book book = new Book("Сборник рассказов", "И. Иванов", 320);
        Novel novel = new Novel("Мастер и Маргарита", "М. Булгаков", 480, "Модернизм");
        Textbook textbook = new Textbook("Java. Полное руководство", "Г. Шилдт", 1376, "Программирование");

        System.out.println("Перегрузка");
        System.out.println("Book");
        book.read();
        book.read(25);
        book.read("Введение");

        System.out.println("\nNovel");
        novel.read();
        novel.read(40);
        novel.read("Глава 1");
        novel.read(10, "задумчивое");

        System.out.println("\nTextbook");
        textbook.read();
        textbook.read(15);
        textbook.read("Наследование");
        textbook.read("Наследование", 5);

        System.out.println("\nПереопределение");
        Book[] books = { book, novel, textbook };
        for (Book b : books) {
            System.out.println(b.getTitle() + " -> жанр: " + b.getGenre());
            b.read();
        }

        for (Book b : books) {
            if (b instanceof Novel n) {
                System.out.println("Это роман, направление: " + n.getLiteraryMovement());
            } else if (b instanceof Textbook t) {
                System.out.println("Это учебник, предмет: " + t.getSubject());
            } else {
                System.out.println("Это обычная книга");
            }
        }

        Book dynamicBook = novel;
        System.out.println("getGenre() -> " + dynamicBook.getGenre());
        dynamicBook.read();

        System.out.println("\nИтоговые объекты");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}