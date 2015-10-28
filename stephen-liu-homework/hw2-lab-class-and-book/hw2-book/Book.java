
/**
 * A class representing a book object.
 * 
 * @author Stephen Liu 
 * @version 2014/09/17
 */
public class Book
{
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private int borrowed;
    private boolean courseText;
    
    /**
     * Constructor for the book class. Creates a book with an
     * author, the title, the number of pages and whether it's
     * a course text.
     * 
     * @param bookAuthor the author of the book.
     * @param bookTitle the title of the book.
     * @param bookPages the number of pages in the book.
     * @param isCourseText whether the book is a course text.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages, boolean isCourseText)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
        refNumber = "";
        borrowed = 0;
        courseText = isCourseText;
    }
    
    /**
     * Gets the author of the book.
     * 
     * @return the author of the book.
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Gets the title of the book.
     * 
     * @return the title of the book.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Gets the number of pages in the book.
     * 
     * @return the number of pages in the book.
     */
    public int getPages()
    {
        return pages;
    }
    
    /**
     * Gets the reference number of the book.
     * 
     * @return the reference number of the book.
     */
    public String getRefNumber()
    {
        return refNumber;
    }
    
    /**
     * Gets the number of times the book has been borrowed.
     * 
     * @return the number of times the book has been borrowed.
     */
    public int getBorrowed()
    {
        return borrowed;
    }
    
    /**
     * Determine whether the book is a course text.
     * 
     * @return whether or not the book is a course text.
     */
    public boolean isCourseText()
    {
        return courseText;
    }
    
    /**
     * Sets the reference number for the book.
     * 
     * @param ref the reference number of the book.
     */
    public void setRefNumber(String ref)
    {
        if (ref.length() < 3) {
            System.out.println("Error: ref should be at least 3 characters long.");
        }
        else {
            refNumber = ref;
        }
    }
    
    /**
     * Borrows the book. Increments the number of times the
     * book has been borrowed.
     */
    public void borrow()
    {
        borrowed++;
    }
    
    /**
     * Prints the name of the author of the book.
     */
    public void printAuthor()
    {
        System.out.println(author);
    }
    
    /**
     * Prints the title of the book.
     */
    public void printTitle()
    {
        System.out.println(title);
    }
    
    /**
     * Prints all the details of the book.
     */
    public void printDetails()
    {
        String titleStr = "Title: " + title + ", ";
        String authorStr = "Author: " + author + ", ";
        String pagesStr = "Pages: " + pages + ", ";
        String borrowedStr = "Borrowed: " + borrowed + " times, ";
        String refStr = "Reference Number: ZZZ";
        
        if (refNumber.length() > 0) {
            refStr = "Reference Number: " + refNumber;
        }
        
        System.out.println(titleStr + authorStr + pagesStr + borrowedStr + refStr);
    }
}
