package ua.epam.task_2.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Realisation flyweight pattern factory for words and punctuation marks
 *
 * @author Dennis
 *
 * on 11/17/2015.
 */
public class SmallTextItemFactory {
    private static SmallTextItemFactory instance;
    private Map<String, SmallTextItem> pool = new HashMap<>();
    private Pattern pattern = Pattern.compile("\\W");

    private SmallTextItemFactory() {}

    public static SmallTextItemFactory getInstance() {
        if (instance == null) {
            instance = new SmallTextItemFactory();
        }

        return instance;
    }

    public SmallTextItem getItem(String key) {
        if (pool.containsKey(key)) {
            return pool.get(key);
        }

        Matcher matcher = pattern.matcher(key);
        SmallTextItem item;

        if (matcher.matches()) {
            item = new PunctuationMark(key);
        } else {
            item = new Word(key);
        }

        pool.put(key, item);
        return item;
    }
}
