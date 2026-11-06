package lab14;

import lab14.exception.FileProcessingException;
import lab14.exception.InvalidDataException;
import lab14.task1.HobbyTask;
import lab14.task2.EvenNumbersTask;
import lab14.task3.DivisibleByFourTask;
import lab14.task4.AverageLightTask;
import lab14.task5.OddNumbersTask;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            runSafely("Задание 1", () -> HobbyTask.execute());
            runSafely("Задание 2", () -> EvenNumbersTask.execute(scanner));
            runSafely("Задание 3", DivisibleByFourTask::execute);
            runSafely("Задание 4", () -> AverageLightTask.execute(scanner));
            runSafely("Задание 5", OddNumbersTask::execute);

            System.out.println("=== Все задания выполнены ===");
        }
    }

    @FunctionalInterface
    private interface Task {
        void run() throws FileProcessingException, InvalidDataException;
    }

    private static void runSafely(String title, Task task) {
        try {
            task.run();
        } catch (FileProcessingException e) {
            System.err.println("[" + title + "] Ошибка работы с файлами: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("  Причина: " + e.getCause().getClass().getSimpleName()
                        + ": " + e.getCause().getMessage());
            }
        } catch (InvalidDataException e) {
            System.err.println("[" + title + "] Некорректные данные: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("[" + title + "] Непредвиденная ошибка: "
                    + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}