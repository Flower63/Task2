package ua.epam.task_2.entity;

/**
 * Abstract class to represent words and punctuation marks.
 *
 * <strong>To create instances use {@link SmallTextItemFactory#getItem(String) method}</strong>
 *
 * @author Dennis
 *
 * on 11/19/2015.
 */
public abstract class SmallTextItem extends TextItem {
    public SmallTextItem(String content) {
        super(content);
    }
}
