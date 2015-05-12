package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 12.05.2015.
 * Во всех вопросительных предложения, найти и распечатать слова заданной длинны
 */
public class Task4 {
    public static void main(String[] args) {
        String text = " Найти! и вывести предложение из текста. В этом этом предложении этом максимально количество одинаковых слов? В этом предложении мало слов! Привет.";
        String[] arrayText = text.split("[\\?]+");
        for (int i = 0; i <arrayText.length-2 ; i++) {
            String[] arrayQuestion = text.split("[\\!\\.]+");

        }
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
