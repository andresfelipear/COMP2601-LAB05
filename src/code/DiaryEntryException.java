/**
 * DiaryEntryException
 *
 * Custom exception class for handling errors related to diary entries.
 * Thrown when a diary entry's date or content is invalid.
 *
 * @author Andres Arevalo, Lida Zarei & Raaz
 * @version 1.0
 */
public class DiaryEntryException extends Exception
{
    /**
     * Constructs a new DiaryEntryException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public DiaryEntryException(final String message)
    {
        super(message);
    }
}
