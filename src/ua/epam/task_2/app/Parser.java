package ua.epam.task_2.app;

import ua.epam.task_2.entity.Sentence;
import ua.epam.task_2.entity.Word;
import ua.epam.task_2.entity.WordFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dennis
 *
 * on 11/17/2015.
 */
public class Parser {

    private Pattern replacePattern;
    private Pattern splitWordPattern;
    private Pattern splitSentencePattern;
    private WordFactory factory;

    public Parser() {
        replacePattern = Pattern.compile("[\\.,?!]");
        splitWordPattern = Pattern.compile("\\s");
        splitSentencePattern = Pattern.compile("[!?\\.]\\s");
        factory = WordFactory.getInstance();
    }

    public List<Word> getWords(String text) {
        List<Word> words = new ArrayList<>();

        Matcher matcherR = replacePattern.matcher(text);
        text = matcherR.replaceAll("");

        String[] content = splitWordPattern.split(text);

        for (String string : content) {
            words.add(factory.getWord(string.toLowerCase()));
        }

        return words;
    }

    public List<Sentence> getSentences(String text) {
        List<Sentence> sentences = new ArrayList<>();

        String[] content = splitSentencePattern.split(text);

        for (String string : content) {
            sentences.add(new Sentence(string.toLowerCase(), getWords(string)));
        }

        return sentences;
    }
}
