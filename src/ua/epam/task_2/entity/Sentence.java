package ua.epam.task_2.entity;

import java.util.List;

/**
 * Created by Dennis
 *
 * on 11/17/2015.
 */
public class Sentence extends TextItem {
    private List<TextItem> words;

    public Sentence(String content, List<TextItem> words) {
        super(content);
        this.words = words;
    }

    public List<TextItem> getWords() {
        return words;
    }

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
