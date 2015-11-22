package ua.epam.task_2.entity;

/**
 * Common super class for all sort of text items
 *
 * @author Dennis
 *
 * on 11/19/2015.
 */
public abstract class TextItem {

    /**
     * String representation of item
     */
    String content;

    /**
     * Constructor
     *
     * @param content Item content
     */
    public TextItem(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextItem)) return false;

        TextItem textItem = (TextItem) o;

        return !(getContent() != null ? !getContent().equalsIgnoreCase(textItem.getContent()) : textItem.getContent() != null);

    }

    @Override
    public int hashCode() {
        return getContent() != null ? getContent().hashCode() : 0;
    }
}
