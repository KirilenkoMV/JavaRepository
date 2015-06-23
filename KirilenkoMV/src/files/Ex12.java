package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by asus on 08.06.2015.
 * Имеется файл с текстом, в котором присутствуют числа. Найти все числа,
 * распечатать, посчитать сумму, убрать все повторяющиеся числа и сново распечатать.
 */
public class Ex12 {
    public static void main(String[] args) {
        File file = new File("./KirilenkoMV/src/files/file with digits.txt");
        List<Integer> integerList = new ArrayList<Integer>();
        Set<Integer> uniqIntegers = new HashSet<Integer>();

        findRegexInFile(file, "\\d+", integerList);
        Integer summa = 0;
        for (Integer digit : integerList) {
            System.out.print(digit + " ");
            summa += digit;
        }
        System.out.println("    summa = " + summa);

        uniqIntegers.addAll(integerList);
        for (Integer digit : uniqIntegers) {
            System.out.print(digit + " ");
        }

    }

    private static void findRegexInFile(File file, String regex, List list) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String res = bufferedReader.readLine();
            Pattern patternPunct = Pattern.compile(regex);
            while (res != null) {
                Matcher matcher = patternPunct.matcher(res);
                while (matcher.find()) {
                    list.add(Integer.parseInt(matcher.group()));
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
    }
}
