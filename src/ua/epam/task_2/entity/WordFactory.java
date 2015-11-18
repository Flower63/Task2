package ua.epam.task_2.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dennis
 *
 * on 11/17/2015.
 */
public class WordFactory {
    private static WordFactory instance;
    private Map<String, Word> pool = new HashMap<>();

    private WordFactory() {}

    public static WordFactory getInstance() {
        if (instance != null) {
            instance = new WordFactory();
        }

        return instance;
    }

    public Word getWord(String key) {
        if (pool.containsKey(key)) {
            return pool.get(key);
        }

        Word word = new Word(key);
        pool.put(key, word);

        return word;
    }
}
