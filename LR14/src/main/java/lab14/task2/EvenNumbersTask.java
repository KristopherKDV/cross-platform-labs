package lab14.task2;

import lab14.exception.FileProcessingException;
import lab14.exception.InvalidDataException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenNumbersTask {

    private static final String FILE_NAME = "f.txt";
    private static final int COUNT = 10;

    public static void execute(Scanner scanner) throws FileProcessingException, InvalidDataException {
        List<Integer> numbers = readNumbers(scanner);
        writeNumbers(numbers);
        List<Integer> readBack = readFromFile();

        System.out.println("Введённые числа");
        System.out.println(readBack);

        long evenCount = readBack.stream().filter(n -> n % 2 == 0).count();
        System.out.println("Количество чётных чисел: " + evenCount);
        System.out.println();
    }

    private static List<Integer> readNumbers(Scanner scanner) throws InvalidDataException {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Введите " + COUNT + " целых чисел");
        while (numbers.size() < COUNT) {
            System.out.print("Число " + (numbers.size() + 1) + ": ");
            String token;
            try {
                token = scanner.nextLine().trim();
            } catch (Exception e) {
                throw new InvalidDataException("Ошибка чтения с клавиатуры: " + e.getMessage(), e);
            }
            if (token.isEmpty()) {
                System.out.println("Пустой ввод, повторите.");
                continue;
            }
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.out.println("'" + token + "' не является целым числом. Повторите.");
            }
        }
        return numbers;
    }

    private static void writeNumbers(List<Integer> numbers) throws FileProcessingException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_NAME), StandardCharsets.UTF_8))) {
            for (int n : numbers) {
                writer.write(Integer.toString(n));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка записи в файл " + FILE_NAME + ": " + e.getMessage(), e);
        }
    }

    private static List<Integer> readFromFile() throws FileProcessingException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))) {
            String line;
            int lineNo = 0;
            while ((line = reader.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    numbers.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    throw new FileProcessingException(
                            "Строка " + lineNo + " файла " + FILE_NAME + " не является числом: " + line, e);
                }
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка чтения файла " + FILE_NAME + ": " + e.getMessage(), e);
        }
        return numbers;
    }
}