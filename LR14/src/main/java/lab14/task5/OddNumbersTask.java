package lab14.task5;

import lab14.exception.FileProcessingException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OddNumbersTask {

    private static final String FILE_NAME = "odd_check.txt";
    private static final int COUNT = 10;

    public static void execute() throws FileProcessingException {
        Random random = new Random();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            numbers.add(random.nextInt(100) - 50);
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_NAME), StandardCharsets.UTF_8))) {
            for (int n : numbers) {
                writer.write(Integer.toString(n));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка записи " + FILE_NAME + ": " + e.getMessage(), e);
        }

        List<Integer> readBack = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))) {
            String line;
            int lineNo = 0;
            while ((line = reader.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    readBack.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    throw new FileProcessingException(
                            "Строка " + lineNo + " файла " + FILE_NAME + " не является числом: " + line, e);
                }
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка чтения " + FILE_NAME + ": " + e.getMessage(), e);
        }

        long oddCount = readBack.stream().filter(n -> n % 2 != 0).count();
        System.out.println("Проверка нечётных значений");
        System.out.println("Содержимое файла: " + readBack);
        System.out.println("Количество нечётных значений: " + oddCount);
        System.out.println();
    }
}