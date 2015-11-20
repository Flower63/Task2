package ua.epam.task_2.app;

import ua.epam.task_2.entity.TextItem;
import ua.epam.task_2.entity.Word;
import ua.epam.task_2.util.DataSource;
import ua.epam.task_2.util.DataSourceFile;

import java.util.List;

/**
 * Created by Dennis
 *
 * on 11/17/2015.
 */
public class Main {
    public static void main(String[] args) {
        DataSource source = new DataSourceFile();
        String text = source.getText();

        Parser parser = new Parser();
//        List<TextItem> list = parser.findSentences(text);
//
//        for (TextItem item : list) {
//            System.out.println(item.getContent() + " : " + item.getClass().getSimpleName());
//        }

        String something = "If your family personal computer is hooked into a phone\n" +
                "line, it might offer soundless help, but again, it's not in your room";
        List<TextItem> result = parser.getWords(something);

        for (TextItem item : result) {
            System.out.println(item.getContent() + " : " + item.getClass().getSimpleName());
        }
    }
}
