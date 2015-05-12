package strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kirilenko_MV on 30.04.2015.
 * найти и вывести предложение из текста, в котором максимальное количество одинаковых слов
 */
public class Task1 {
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

        int max = 0;
        String maxReapeatText = "";
        for (String substring : listTexts) {
            int maxWords = MaxRepeatWords(substring);
            if (max < maxWords) {
                max = maxWords;
                maxReapeatText = substring;
            }
        }

        System.out.println(maxReapeatText);
    }

    private static int MaxRepeatWords(String text) {
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher;
        int maxWordCounter = 0;
        matcher = pattern.matcher(text);
        //получаю все уникальные слова в строке
        Set<String> words = new HashSet();
        while (matcher.find()) {
            //System.out.println(matcher.group());
            words.add(matcher.group());
        }
        for (String word : words) {
            String substr = text;
            int wordCount = 0;
            while (substr.indexOf(" " + word + " ") != -1) {
                substr = substr.substring(substr.indexOf(word) + word.length());
                wordCount++;
            }

            //System.out.println(text + " : " + word + " - " + wordCount);
            if (maxWordCounter < wordCount) {
                maxWordCounter = wordCount;
            }
        }
        return maxWordCounter;
    }
}
