package lab14.task3;

import lab14.exception.FileProcessingException;
import lab14.exception.InvalidDataException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DivisibleByFourTask {

    private static final String FILE_F = "f_numbers.txt";
    private static final String FILE_G = "g_div4.txt";
    private static final String FILE_H = "h_other.txt";
    private static final int COUNT = 20;

    public static void execute() throws FileProcessingException, InvalidDataException {
        Random random = new Random();

        List<Integer> source = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            source.add(random.nextInt(201) - 100);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(FILE_F)) {
            for (int n : source) {
                writer.write(Integer.toString(n));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка записи " + FILE_F + ": " + e.getMessage(), e);
        }

        List<Integer> div4 = new ArrayList<>();
        List<Integer> other = new ArrayList<>();
        for (int n : source) {
            if (n % 4 == 0) div4.add(n);
            else other.add(n);
        }

        writeList(FILE_G, div4);
        writeList(FILE_H, other);

        System.out.println("Разделение чисел по признаку делимости на 4");
        System.out.println("Исходные (" + FILE_F + "): " + source);
        System.out.println("Делятся на 4 (" + FILE_G + "): " + div4);
        System.out.println("Остальные (" + FILE_H + "): " + other);
        System.out.println();
    }

    private static void writeList(String fileName, List<Integer> list) throws FileProcessingException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            for (int n : list) {
                writer.write(Integer.toString(n));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка записи " + fileName + ": " + e.getMessage(), e);
        }
    }

    private static final class Files {
        static BufferedWriter newBufferedWriter(String name) throws IOException {
            return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), StandardCharsets.UTF_8));
        }
    }
}