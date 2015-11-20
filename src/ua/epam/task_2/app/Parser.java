package ua.epam.task_2.app;

import ua.epam.task_2.entity.*;

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

    private SmallTextItemFactory factory = SmallTextItemFactory.getInstance();;
    private Pattern punctuationPattern = Pattern.compile("##(\\d+)([\\.,\\-:!\\?])");
    private Pattern codePattern = Pattern.compile("(##\\d+[\\.!\\?]\\s)+(.+?)\\s##(\\d+)[\\.!\\?]");
    private Pattern sentencesPattern = Pattern.compile("([A-ZА-Я][A-ZА-Яa-zа-я\\d\\s\\.,']*?)[\\.?!]\\s[A-ZА-Я]");
    private Pattern lastSentencePattern = Pattern.compile(".*([A-ZА-Я].*?)[\\.\\?!]\\s$");

    public List<TextItem> findSentences(String text) {
        Matcher sentencesMatcher = sentencesPattern.matcher(text);

        List<TextItem> content = new ArrayList<>();

        int index = 0;

        /*
         * Finding average sentences
         * and adding them to list
         */
        while (sentencesMatcher.find(index)) {
            String str = sentencesMatcher.group(1);
            index = text.indexOf(str, index) + str.length() - 1;

            content.add(new Sentence(str, getWords(str)));
        }

        /*
         * Adding last sentence
         */
        Matcher lastSentenceMatcher = lastSentencePattern.matcher(text);
        if (lastSentenceMatcher.find()) {
            String last = lastSentenceMatcher.group(1);

            content.add(new Sentence(last, getWords(last)));
        }

        /*
         * Replacing all sentences with special marks
         */
        text = replaceTextItems(content, text);

        /*
         * Getting punctuation marks
         */
        getPunctuationMarks(content, text);

        /*
         * Getting code position
         * and add code in this position
         */
        Matcher codeMatcher = codePattern.matcher(text);
        index = 0;
        while (codeMatcher.find()) {
            int num = Integer.parseInt(codeMatcher.group(3)) * 2;
            String str = codeMatcher.group(2);

            content.add(num + index++, new Code(str));
        }

        return content;
    }

    public List<TextItem> getWords(String text) {
        List<TextItem> words = new ArrayList<>();
        Pattern wordPattern = Pattern.compile("([A-Za-zА-Яа-я']+)[\\.,\\?\\s:]{0,3}");
        Matcher wordMatcher = wordPattern.matcher(text);

        /*
         * Adding words into list
         */
        while (wordMatcher.find()) {
            String str = wordMatcher.group(1);
            words.add(factory.getItem(str));
        }

        /*
         * Replacing all words with special marks
         */
        text = replaceTextItems(words, text);

        /*
         * Getting punctuation marks
         */
        getPunctuationMarks(words, text);

        return words;
    }

    /**
     * Replacing given patterns in list with special symbols. It's needed
     * to find punctuation marks and code snippets in text and add them to
     * proper position in list of items
     *
     * @param list List, that contains sequence of objects, that represents
     *             text snippets
     *
     * @param text Text to modify
     * @return Text with special meta-characters instead of snippets, given
     *         in list
     */
    private String replaceTextItems(List<TextItem> list, String text) {
        int index = 0;

        for (TextItem item : list) {
            text = text.replaceFirst(item.getContent(), "##" + index++);
        }

        return text;
    }

    /**
     * Collecting all punctuation marks from text.
     *
     * @param list List of objects (words or sentences) that should be equipped
     *             with punctuation marks
     * @param text Text, that should contain special meta-characters.
     *
     * @see ua.epam.task_2.app.Parser#replaceTextItems(List, String)
     */
    private void getPunctuationMarks(List<TextItem> list, String text) {
        Matcher punctuationMatcher = punctuationPattern.matcher(text);

        int i = 0;

        while (punctuationMatcher.find()) {
            int index = Integer.parseInt(punctuationMatcher.group(1)) + i;
            String mark = punctuationMatcher.group(2);

            if (!mark.isEmpty()) {
                list.add(index + 1, factory.getItem(mark));
                i++;
            }
        }
    }
}
