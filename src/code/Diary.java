import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Diary
 *
 * @author Andres Arevalo & Lida Zarei
 * @version 1.0
 */
public class Diary
{

    private static final String FILE_NAME;
    private static final int DATE;
    private static final int CONTENT;

    static
    {
        FILE_NAME = "diary.txt";
        DATE = 0;
        CONTENT = 1;
    }

    /**
     * Adds a new entry to the diary.
     * The entry is appended to the diary file.
     *
     * @param date the date of the diary entry in the format YYYY-MM-DD
     * @param content the content of the diary entry
     */
    public void addEntry(final String date, final String content)
    {
        final DiaryEntry    diaryEntry;
        FileWriter          fileWriter;

        fileWriter = null;

        try
        {
            fileWriter = new FileWriter(FILE_NAME, true);
            diaryEntry = new DiaryEntry(date, content);

            fileWriter.write(String.format("%s|%s", date, content) + System.lineSeparator());
        }
        catch (final IOException e)
        {
            System.out.println("There was an error creating the file");
        }
        catch (final DiaryEntryException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(fileWriter != null)
                {
                    fileWriter.close();
                }
            }
            catch(IOException e)
            {
                System.out.println("Error while closing the file");
            }
        }
    }

    /**
     * Displays all diary entries.
     * Reads each entry from the diary file and prints it to the console.
     */
    public void viewAllEntries()
    {
        FileReader fileReader;
        Scanner    scanner;
        DiaryEntry diaryEntry;
        String[]   diaryEntryArray;
        String     date;
        String     content;

        fileReader = null;
        scanner = null;

        try
        {
            fileReader = new FileReader(FILE_NAME);
            scanner = new Scanner(fileReader);

            while(scanner.hasNext())
            {
                diaryEntryArray = scanner.nextLine().split("\\|");
                date = diaryEntryArray[DATE];
                content = diaryEntryArray[CONTENT];
                diaryEntry = new DiaryEntry(date, content);

                System.out.println(diaryEntry);
                System.out.println();
            }
        }
        catch (final IOException e)
        {
            System.out.println("There was an error reading the file");
        }
        catch (final DiaryEntryException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(fileReader != null)
                {
                    fileReader.close();
                }
            }
            catch(IOException e)
            {
                System.out.println("Error while closing the file");
            }
        }
    }

    /**
     * Searches for diary entries by a specific date.
     * Reads each entry from the diary file and prints those that match the specified date.
     *
     * @param searchDate the date to search for in the format YYYY-MM-DD
     */
    public void searchEntriesByDate(final String searchDate)
    {
        FileReader fileReader;
        Scanner    scanner;
        DiaryEntry diaryEntry;
        String[]   diaryEntryArray;
        String     date;
        String     content;

        fileReader = null;
        scanner = null;

        try
        {
            fileReader = new FileReader(FILE_NAME);
            scanner = new Scanner(fileReader);

            System.out.println("Searching entries by date " + searchDate + "\n");
            while(scanner.hasNext())
            {
                diaryEntryArray = scanner.nextLine().split("\\|");
                date = diaryEntryArray[DATE];
                content = diaryEntryArray[CONTENT];

                if(searchDate.equalsIgnoreCase(date))
                {
                    diaryEntry = new DiaryEntry(date, content);
                    System.out.println(diaryEntry);
                }
            }
        }
        catch (final IOException e)
        {
            System.out.println("There was an error reading the file");
        }
        catch (final DiaryEntryException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(fileReader != null)
                {
                    fileReader.close();
                }
            }
            catch(IOException e)
            {
                System.out.println("Error while closing the file");
            }
        }
    }
}
