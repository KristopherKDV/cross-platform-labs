package lab14.task1;

import lab14.exception.FileProcessingException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class HobbyTask {

    private static final String FILE_NAME = "hobby.txt";

    public static void execute() throws FileProcessingException {
        Path path = Path.of(FILE_NAME);

        String content = """
                Хобби: Актёр-администратор в сети квест-румов.
                Обязанности:
                 - встреча гостей и проведение брифинга;
                 - отыгрывание ролей персонажей внутри квеста;
                 - контроль прохождения и подсказки;
                 - координация между командами и персоналом;
                 - ведение отчётности по сменам.
                Опыт: 1 год 3 месяца 22 дня, более 500 успешных игр.
                """;

        try {
            Files.writeString(path, content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FileProcessingException("Не удалось записать файл хобби: " + e.getMessage(), e);
        }

        printFileInfo(path);
        printFileContent(path);
    }

    private static void printFileInfo(Path path) throws FileProcessingException {
        try {
            if (!Files.exists(path)) {
                throw new FileProcessingException("Файл не существует: " + path.toAbsolutePath());
            }
            System.out.println("Имя файла:      " + path.getFileName());
            System.out.println("Абс. путь:      " + path.toAbsolutePath());
            System.out.println("Размер:         " + Files.size(path) + " байт");
            System.out.println("Читаемый:       " + Files.isReadable(path));
            System.out.println("Записываемый:   " + Files.isWritable(path));
            System.out.println("Обычный файл:   " + Files.isRegularFile(path));
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка при получении свойств файла: " + e.getMessage(), e);
        }
    }

    private static void printFileContent(Path path) throws FileProcessingException {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка чтения файла: " + e.getMessage(), e);
        }
        System.out.println();
    }
}