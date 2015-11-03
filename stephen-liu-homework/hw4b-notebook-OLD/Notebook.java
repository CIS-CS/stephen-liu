import java.util.ArrayList;

/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2008.03.03
 */
public class Notebook
{
    // Storage for an arbitrary number of notes.
    private ArrayList<String> notes;
    
    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public Notebook()
    {
        notes = new ArrayList<String>();
    }
    
    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(String note)
    {
        notes.add(note);
    }
    
    /**
     * @return The number of notes currently in the notebook.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }
    
    /**
     * Show a note.
     * @param noteNumber The number of the note to be shown.
     */
    public void showNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // This is not a valid note number, so do nothing.
        }
        else if(noteNumber < numberOfNotes()) {
            // This is a valid note number, so we can print it.
            System.out.println(notes.get(noteNumber));
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }
    
    /**
     * List the number of notes, numbering them on the side.
     */
    public void listNotes()
    {
        for (int i = 0; i < numberOfNotes(); i++) {
            System.out.println(i + " ==> " + notes.get(i));
        }
    }
    
    /**
     * Remove a note given the note number.
     * @param noteNumber The number of the note to be removed.
     */
    public void removeNote(int noteNumber)
    {
        if ((noteNumber < numberOfNotes()) && noteNumber > 0) {
            notes.remove(noteNumber);
        }
        else {
            System.out.println("Please input a valid note number!");
        }
    }
    
    /**
     * Search for the first occurance of a note that contains a given
     * search string.
     * @param searchString The search term to be searched for.
     */
    public void search(String searchString)
    {
        boolean found = false;
        for (int i = 0; i < numberOfNotes(); i++) {
            if (notes.get(i).contains(searchString)) {
                found = true;
                System.out.println("Search term was found in the "
                                    + (i + 1) + "th note.");
                break;
            }
        }
        
        if (found == false) {
            System.out.println("Search term not found");
        }
    }
    
    public void printArrayListContents() {
        // 1st way: for-each loop. Iterate through all the contents of
        // the array list. In this case, in each iteration in this
        // loop, the variable note is one element in the arraylist.
        /*for (String note : notes) {
            System.out.println(note);
        }*/
        
        /*
         * 2nd way:
         * For-loop:
         */
        for (int i = 0; i < notes.size(); i++) {
            System.out.println(notes.get(i));
        }
    }
}
