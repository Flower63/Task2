package ua.epam.task_2.entity;

import java.util.List;

/**
 * Entity for sentence
 *
 * @author Dennis
 *
 * on 11/17/2015.
 */
public class Sentence extends TextItem {

    /**
     * List of words and punctuation marks in sentence
     */
    private List<TextItem> words;

    /**
     * Constructor
     *
     * @param content String, that represents sentence
     * @param words List of words and punctuation marks in sentence
     */
    public Sentence(String content, List<TextItem> words) {
        super(content);
        this.words = words;
    }

    /**
     * Getter for words
     */
    public List<TextItem> getWords() {
        return words;
    }

    /**
     * Method to count entrance of given word in sentence
     *
     * @param word Specified word
     * @return Number of word entrances
     */
    public int countWords(TextItem word) {
        int count = 0;

        for (TextItem item : words) {
            if (item.equals(word)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        if (!super.equals(o)) return false;

        Sentence sentence = (Sentence) o;

        return getWords().equals(sentence.getWords());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getWords().hashCode();
        return result;
    }
}
