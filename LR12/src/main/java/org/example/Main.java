package org.example;

import model.Book;
import model.Comic;
import model.Novel;
import model.Textbook;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Book> books = new LinkedHashMap<>();

        books.put("Мастер и Маргарита",
                new Novel("Мастер и Маргарита", 101, 480, "Мистика"));
        books.put("Преступление и наказание",
                new Novel("Преступление и наказание", 102, 672, "Психологический роман"));
        books.put("1984",
                new Novel("1984", 103, 328, "Антиутопия"));

        books.put("Алгебра 9 класс",
                new Textbook("Алгебра 9 класс", 201, 256, "Математика"));
        books.put("Физика 10 класс",
                new Textbook("Физика 10 класс", 202, 384, "Физика"));
        books.put("Основы Java",
                new Textbook("Основы Java", 203, 512, "Программирование"));

        books.put("Человек-Паук",
                new Comic("Человек-Паук", 301, 96, "Стив Дитко"));
        books.put("Бэтмен: Год первый",
                new Comic("Бэтмен: Год первый", 302, 144, "Дэвид Маццукелли"));

        for (Map.Entry<String, Book> entry : books.entrySet()) {
            System.out.printf("Ключ: %-25s -> Значение: %s%n",
                    entry.getKey(), entry.getValue());
        }

        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Book> entry = iterator.next();
            System.out.printf("Ключ: %-25s -> Значение: %s%n",
                    entry.getKey(), entry.getValue());
        }


        int novels = 0, textbooks = 0, comics = 0;
        for (Book b : books.values()) {
            if (b instanceof Novel) novels++;
            else if (b instanceof Textbook) textbooks++;
            else if (b instanceof Comic) comics++;
        }
        System.out.printf("%nВсего добавлено: Novel=%d, Textbook=%d, Comic=%d (итого %d)%n",
                novels, textbooks, comics, books.size());

        System.out.println("Размер коллекции: " + books.size());
        Book sample = books.get("1984");
        System.out.println("Получено по ключу без приведения типов: " + sample);
    }
}