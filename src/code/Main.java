import java.util.Scanner;


/**
 * Main
 *
 * @author Andres Arevlao, Lida Zarei & Raaz
 * @version 1.0
 */
public class Main
{
    private static final int ADD_ENTRY = 1;
    private static final int VIEW_ENTRIES = 2;
    private static final int SEARCH_BY_DATE = 3;
    private static final int EXIT = 4;

    public static void main(String[] args)
    {
        final Scanner   sc;
        final Diary     diary;

        int    choice;
        String date;
        String content;
        boolean exit;

        sc = new Scanner(System.in);
        diary = new Diary();
        exit = true;

        while(exit)
        {
            System.out.print("My Diary.\n" +
                                       "1.Add an entry.\n" +
                                       "2.View all entries.\n" +
                                       "3.Search an entry by date.\n" +
                                       "4.Exit.\n\n" +
                                       "Please choose one option: ");

            choice  = sc.nextInt();

            switch(choice)
            {
                case ADD_ENTRY:
                    System.out.println("Add an Entry.");
                    System.out.print("\nEnter the date(YYYY-MM-DD): ");
                    date = sc.next();
                    sc.nextLine();

                    System.out.print("Enter the content: ");
                    content = sc.nextLine();

                    diary.addEntry(date, content);
                    System.out.println();
                    break;

                case VIEW_ENTRIES:
                    System.out.println("\nAll entries in my diary.");
                    diary.viewAllEntries();
                    break;

                case SEARCH_BY_DATE:
                    System.out.print("\nSearch date(yyyy-mm-dd): ");
                    date = sc.next();
                    diary.searchEntriesByDate(date);
                    System.out.println();
                    break;

                case EXIT:
                    exit = false;
                    break;

                default:
                    System.out.println("\nInvalid Choice. Try Again.\n");
                    break;
            }
        }
    }
}
