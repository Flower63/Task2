package ua.epam.task_2.app;

import ua.epam.task_2.entity.SmallTextItemFactory;
import ua.epam.task_2.entity.TextItem;
import ua.epam.task_2.entity.Word;
import ua.epam.task_2.util.DataSource;
import ua.epam.task_2.util.DataSourceFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Application entry point,
 * controller role
 *
 * @author Dennis
 *
 * on 11/17/2015.
 */
public class Main {
    public static void main(String[] args) {

        /*
         * Creating data source instance
         */
        DataSource source = new DataSourceFile();

        /*
         * Getting text to parse
         */
        String text = source.getText();

        /*
         * Getting View
         */
        View view = View.getInstance();

        /*
         * Getting factory to make list of words
         */
        SmallTextItemFactory factory = SmallTextItemFactory.getInstance();

        /*
         * Making list and fill it with random words
         */
        List<Word> words = new ArrayList<Word>(){{
            add((Word) factory.getItem("in"));
            add((Word) factory.getItem("at"));
            add((Word) factory.getItem("you"));
            add((Word) factory.getItem("are"));
            add((Word) factory.getItem("and"));
        }};

        /*
         * Make model instance
         */
        WordEntry model = new WordEntry();

        /*
         * Executing
         */
        model.execute(text, words, view);

        //sentencesDemo(text);

        //wordsDemo();
    }

    /*
     * Sentence parsing demonstration
     */
    private static void sentencesDemo(String text) {
        Parser parser = new Parser();
        List<TextItem> list = parser.getSentences(text);

        for (TextItem item : list) {
           System.out.println(item.getContent() + " : " + item.getClass().getSimpleName());
        }
    }

    /*
     * Words parsing demonstration
     */
    private static void wordsDemo() {
        Parser parser = new Parser();
        String something = "If your family personal computer is hooked into a phone\n" +
                "line, it might offer soundless help, but again, it's not in your room";
        List<TextItem> result = parser.getWords(something);

        for (TextItem item : result) {
            System.out.println(item.getContent() + " : " + item.getClass().getSimpleName());
        }
    }
}
