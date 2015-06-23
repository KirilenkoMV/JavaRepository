package files;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by asus on 08.06.2015.
 * Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.
 */
public class Ex11 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        createFileWithTestText(file);
        int punctuals = countRegexInFile(file, "\\p{Punct}");
        System.out.println("Знаков препинания = " + punctuals);
        int words = countRegexInFile(file, "\\s+");
        System.out.println("Слов = " + words);

    }

    private static int countRegexInFile(File file, String regex) {
        int counter = 0;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String res = bufferedReader.readLine();
            Pattern patternPunct = Pattern.compile(regex);
            Matcher matcher;
            while (res != null) {
                matcher = patternPunct.matcher(res);
                while (matcher.find()) {
                    counter++;
                }
                res = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return counter;
    }

    private static void createFileWithTestText(File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("Тестовый файл,\n");
            fileWriter.write("с тестовым текстом,\n");
            fileWriter.write("записанным в файл при помощи FileWriter, а затем \n");
            fileWriter.write("прочитанным из файла при помощи BufferedInputStream. ");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
