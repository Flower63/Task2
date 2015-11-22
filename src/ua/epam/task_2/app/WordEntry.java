package ua.epam.task_2.app;

import ua.epam.task_2.entity.Sentence;
import ua.epam.task_2.entity.TextItem;
import ua.epam.task_2.entity.Word;
import ua.epam.task_2.util.WordWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Model for Task 2 Var. 10.
 *
 * It takes list of words and text to parse.
 * First it parses text for sentences, and then iterates over word list
 * to find number if entries in sentences.
 *
 * It uses WordWrapper to count entries and sort list due to this entries
 *
 * @author Dennis
 *
 * on 11/18/2015.
 */
public class WordEntry {

    /**
     * Single method to process input and display results through View
     *
     * @param text Text to parse
     * @param words List of words to iterate
     * @param view View instance to display results
     */
    public void execute(String text, List<Word> words, View view) {

        /*
         * Getting instance of parser
         */
        Parser parser = new Parser();

        /*
         * Finding all available elements in text
         */
        List<TextItem> textItems = parser.getSentences(text);

        /*
         * Filtering list to keep only sentences
         */
        List<TextItem> sentences = textItems.stream().filter(o -> o instanceof Sentence)
                                                        .collect(Collectors.toList());
        /*
         * Creating list of wrappers
         */
        List<WordWrapper> wrappers = new ArrayList<>();

        /*
         * Iterating over list of words.
         * First of all we creating new wrapper with given word,
         * then iterating over sentences for matches, count the matches,
         * and adding wrapper to list with representative counter
         */
        for (Word word : words) {
            WordWrapper wrapper = new WordWrapper(word);

            for (TextItem sentence : sentences) {
                Sentence s = (Sentence) sentence;
                int counter = s.countWords(word);
                wrapper.setCounter(wrapper.getCounter() + counter);
            }

            wrappers.add(wrapper);
        }

        /*
         * Sorting list of wrapper in decrease order by entry number
         */
        wrappers.sort((o1, o2) -> o2.getCounter() - o1.getCounter());

        /*
         * Outputting the result with View
         */
        for (WordWrapper wrapper : wrappers) {
            view.print(wrapper.getWord().getContent() + " " + wrapper.getCounter());
        }
    }
}
