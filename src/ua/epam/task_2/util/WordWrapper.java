package ua.epam.task_2.util;

import ua.epam.task_2.entity.Word;

/**
 * Created by Dennis
 *
 * on 11/20/2015.
 */
public class WordWrapper implements Comparable {
    private Word word;
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

    public void increase() {
        counter++;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int compareTo(Object o) {
        WordWrapper helper = (WordWrapper) o;
        return helper.getCounter() - this.getCounter();
    }
}
