package strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 12.05.2015.
 * Вывести все предложения заданного текста в порядке возрастания количества строк
 */
public class Task2 {
    public static void main(String[] args) {
        String text = " Найти и вывести предложение из текста. В этом этом предложении этом максимально количество одинаковых слов. В этом предложении мало слов.";
        List<String> listTexts = new ArrayList();
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(text);
        int startIndex = 0;
        while (matcher.find()) {
            listTexts.add(text.substring(startIndex, matcher.end()));
            startIndex = matcher.end();
        }

        Map<Integer, String> map = new TreeMap<Integer, String>();
        for (String substring : listTexts) {
            int numberWords = WordCounter(substring);
            map.put(numberWords, substring);
        }
        for (String str : map.values()) {
            System.out.println(str);
        }

    }

    private static int WordCounter(String str) {
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher;
        int maxWordCounter = 0;
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            maxWordCounter++;
        }
        return maxWordCounter;
    }


}
