package ua.epam.task_2.entity;

import java.util.List;

/**
 * Created by Dennis
 *
 * on 11/17/2015.
 */
public class Sentence extends Word {
    private List<Word> words;

    public Sentence(String content, List<Word> words) {
        super(content);
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }
}
