package observer;

public class ConcreteMember implements Member{
    UndoableStringBuilder ourusb = new UndoableStringBuilder();
    /**we Update the pointer of the UndoableStringBuilder's of the member to
     * the GroupAdmin's UndoableStringBuilder .
     * @param usb pointer to GroupAdmin's UndoableStringBuilder object
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        ourusb=usb;
        System.out.println("Member updated.");
    }
    /** a function to print the data of the member
     * @return a string that represent the object of the member
     */
    public String toString() {
        return ourusb.toString();
    }
}
