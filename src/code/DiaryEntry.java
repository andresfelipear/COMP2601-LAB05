/**
 * DiaryEntry
 *
 * @author Andres Arevalo, Lida Zarei & Raaz
 * @version 1.0
 */
public class DiaryEntry
{
    private final String date;
    private final String content;

    private static final String INVALID_CONTENT;
    private static final String ERROR_INVALID_DATE;
    private static final String ERROR_INVALID_CONTENT;

    static
    {
        INVALID_CONTENT = "bcit";
        ERROR_INVALID_DATE = "Invalid date. It should be in the format YYYY-MM-DD";
        ERROR_INVALID_CONTENT = "Invalid content %s. It can't be blank, null or equals to %s";
    }

    /**
     * Constructs a DiaryEntry object with the specified date and content.
     * Validates both the date and content before initializing the object.
     *
     * @param date the date of the diary entry in the format YYYY-MM-DD
     * @param content the content of the diary entry
     * @throws DiaryEntryException if the date or content is invalid
     */
    public DiaryEntry(final String date,
                      final String content) throws DiaryEntryException
    {
        validateDate(date);
        validateContent(content);
        this.date = date;
        this.content = content;
    }

    /**
     * Validates the content of the diary entry.
     * The content must not be null, blank, or equal to the invalid content.
     *
     * @param content the content to be validated
     * @throws DiaryEntryException if the content is invalid
     */
    private static void validateContent(final String content) throws DiaryEntryException
    {
        if(content == null || content.isBlank() || content.equalsIgnoreCase(INVALID_CONTENT))
        {
            throw new DiaryEntryException(
                                            String.format(ERROR_INVALID_CONTENT,
                                            content,
                                            INVALID_CONTENT));
        }
    }

    /**
     * Validates the date of the diary entry.
     * The date must be in the format YYYY-MM-DD.
     *
     * @param date the date to be validated
     * @throws DiaryEntryException if the date is invalid
     */
    private static void validateDate(final String date) throws DiaryEntryException
    {
        final String regex;
        regex = "\\d{4}-\\d{2}-\\d{2}";

        if(!date.matches(regex))
        {
            throw new DiaryEntryException(ERROR_INVALID_DATE);
        }
    }

    /**
     * Returns the date of the diary entry.
     *
     * @return the date of the diary entry
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Returns the content of the diary entry.
     *
     * @return the content of the diary entry
     */
    public String getContent()
    {
        return content;
    }

    /**
     * Returns a string representation of the diary entry.
     * The format is "date(YYYY-MM-DD): [date]\nEntry: [content]".
     *
     * @return a string representation of the diary entry
     */
    @Override
    public String toString()
    {
        return String.format("date(YYYY-MM-DD): %s\nEntry: %s", date, content);
    }
}
