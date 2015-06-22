package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by asus on 08.06.2015.
 * Создать список оценок учеников с помощью ArrayList, заполнить
 * случайными оценками. Удалить неудавлетворительные оценки из списка.
 */
public class Ex7 {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<Integer>(25);
        for (int i = 0; i < 25; i++) {
            marks.add((int) (Math.random() * 10));
            System.out.print(marks.get(i) + " ");
        }
        System.out.println();

        Iterator iterator = marks.iterator();
        while (iterator.hasNext()) {
            int mark = (Integer) iterator.next();
            if (mark < 4) {
                iterator.remove();
            }
        }

        for (Integer mark : marks) {
            System.out.print(mark + " ");
        }

    }
}
