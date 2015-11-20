package ua.epam.task_2.app;

import ua.epam.task_2.entity.Sentence;
import ua.epam.task_2.entity.TextItem;
import ua.epam.task_2.entity.Word;
import ua.epam.task_2.util.WordWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dennis
 *
 * on 11/18/2015.
 */
public class WordEntry {
    public void execute(String text, List<Word> words) {
        Parser parser = new Parser();
        List<TextItem> textItems = parser.findSentences(text);

        List<TextItem> sentences = textItems.stream().filter(o -> o instanceof Sentence)
                                                        .collect(Collectors.toList());
        List<WordWrapper> wrappers = new ArrayList<>();

        for (Word word : words) {
            WordWrapper wrapper = new WordWrapper((Word) word);

            for (TextItem sentence : sentences) {
                Sentence s = (Sentence) sentence;
                int counter = s.countWords(word);
                wrapper.setCounter(wrapper.getCounter() + counter);
            }

            wrappers.add(wrapper);
        }

        wrappers.sort((o1, o2) -> o2.getCounter() - o1.getCounter());

        for (WordWrapper wrapper : wrappers) {
            System.out.println(wrapper.getWord().getContent() + " " + wrapper.getCounter());
        }
    }
}
