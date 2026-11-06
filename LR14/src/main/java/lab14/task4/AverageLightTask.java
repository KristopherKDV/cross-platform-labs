package lab14.task4;

import lab14.exception.FileProcessingException;
import lab14.exception.InvalidDataException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AverageLightTask {

    private static final String FILE_NAME = "light.txt";
    private static final int COUNT = 12;

    public static void execute(Scanner scanner) throws FileProcessingException, InvalidDataException {
        List<Double> values = readValues(scanner);
        writeValues(values);
        List<Double> readBack = readFromFile();

        System.out.println("Значения освещённости (лк)");
        System.out.println(readBack);

        double sum = 0;
        for (double v : readBack) sum += v;
        double average = sum / readBack.size();
        System.out.printf(Locale.US, "Средняя освещённость: %.2f лк%n", average);
        System.out.println();
    }

    private static List<Double> readValues(Scanner scanner) throws InvalidDataException {
        List<Double> list = new ArrayList<>();
        System.out.println("Введите " + COUNT + " вещественных значений освещённости");
        while (list.size() < COUNT) {
            System.out.print("Значение " + (list.size() + 1) + ": ");
            String token;
            try {
                token = scanner.nextLine().trim().replace(',', '.');
            } catch (Exception e) {
                throw new InvalidDataException("Ошибка чтения с клавиатуры: " + e.getMessage(), e);
            }
            if (token.isEmpty()) {
                System.out.println("Пустой ввод, повторите.");
                continue;
            }
            try {
                double v = Double.parseDouble(token);
                if (v < 0) {
                    System.out.println("Освещённость не может быть отрицательной. Повторите.");
                    continue;
                }
                list.add(v);
            } catch (NumberFormatException e) {
                System.out.println("'" + token + "' не является числом. Повторите.");
            }
        }
        return list;
    }

    private static void writeValues(List<Double> values) throws FileProcessingException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_NAME), StandardCharsets.UTF_8))) {
            for (double v : values) {
                writer.write(Double.toString(v));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка записи " + FILE_NAME + ": " + e.getMessage(), e);
        }
    }

    private static List<Double> readFromFile() throws FileProcessingException {
        List<Double> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))) {
            String line;
            int lineNo = 0;
            while ((line = reader.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    list.add(Double.parseDouble(line));
                } catch (NumberFormatException e) {
                    throw new FileProcessingException(
                            "Строка " + lineNo + " файла " + FILE_NAME + " не является числом: " + line, e);
                }
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка чтения " + FILE_NAME + ": " + e.getMessage(), e);
        }
        return list;
    }
}