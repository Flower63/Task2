package ua.epam.task_2.util;

import ua.epam.task_2.entity.Word;

/**
 * Helper wrapper for word. Needed to sort words by entry
 *
 * @author Dennis
 *
 * on 11/20/2015.
 */
public class WordWrapper {

    /**
     * Content
     */
    private Word word;

    /**
     * Counter
     */
    private int counter;

    public WordWrapper(Word word) {
        this.word = word;
    }

    public Word getWord() {
        return word;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
