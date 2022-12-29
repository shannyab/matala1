package observer;
import javax.swing.*;
import java.util.ArrayList;
public class GroupAdmin implements Sender{
    UndoableStringBuilder st= new UndoableStringBuilder();
    ArrayList<Member> observers = new ArrayList<>();
    /**
     * Register the member obj to the ArrayList named observers .
     * @param obj a pointer of the member object
     */
    @Override
    public void register(Member obj) {
        if(observers.contains(obj))
            return;
        observers.add(obj);
    }

    /**
     * Unregister the member obj from the ArrayList named observers
     * @param obj a pointer of the member object
     */
    @Override
    public void unregister(Member obj) {
        if (!observers.contains(obj))
            return;
        observers.remove(obj);

    }

    /**
     *a function that insert a string to the current string from specific index.
     *  notify the members that there has been changes with the GroupAdmin's UndoableStringBuilder
     * @param offset the specific index where we insert the string.
     * @param obj the string inserted
     */
    @Override
    public void insert(int offset, String obj) {
        st.insert( offset, obj);
        notifyMembers();
    }

    /**
     * function that append a string to the end.
     * notify the members that there has been changes with the GroupAdmin's UndoableStringBuilder.
     * @param obj the string appended.
     */
    @Override
    public void append(String obj) {
        st.append(obj);
        notifyMembers();
    }

    /**
     * a function that delete a substring.
     *  * notify the members that there has been changes with the GroupAdmin's UndoableStringBuilder.
     * @param start the first index of the substring we want to delete.
     * @param end the last index of the substring we want to delete.
     */
    @Override
    public void delete(int start, int end) {
        st.delete(start,end);
        notifyMembers();
    }

    /**
     * method that undo the last operation
     * notify the members that there has been changes with the GroupAdmin's UndoableStringBuilder.
     */
    @Override
    public void undo() {
        st.undo();
        notifyMembers();
    }
  /**
   *  Notifies the members there has been changes with the GroupAdmin's UndoableStringBuilder.
   */
    public void notifyMembers() {
        for (Member obj: observers) {
           obj.update(st) ;
        }
    }
    /**
     * function toString for printing the sender's data.
     * @return  a string that represent the object
     */
    @Override
    public String toString() {
        String str = "Members: \n";
        int counter = 1;
        for (Member m: this.observers) {
            str = str + "M" + counter + " - " + m.toString() + "\n";
            counter++;
        }

        return str;
    }
}

