package strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 12.05.2015.
 * Найти такое слово в первом предложении, которого нет в остальных предложениях.
 */
public class Task3 {
    public static void main(String[] args) {
        String text = " Найти и этом вывести количество предложение из текста. В этом этом предложении этом максимально количество одинаковых слов. В этом предложении мало слов.";
        String[] arrayText = text.split("\\.");
        String[] arrayWords = arrayText[0].split(" +");
        System.out.println(Arrays.toString(arrayText));
        System.out.println(Arrays.toString(arrayWords));

        for (int i = 0; i < arrayWords.length; i++) {
            boolean uniqueWord = true;
            for (int j = 1; j < arrayText.length; j++) {
                if (arrayText[j].indexOf(" " + arrayWords[i] + " ") != -1) {
                    uniqueWord = false;
                    break;
                }
            }
            if (uniqueWord) {
                System.out.println(arrayWords[i]);
            }
        }

    }
}
