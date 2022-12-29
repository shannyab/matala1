package observer;

import java.util.Stack;

/**
 *this class is a StringBulider class with support for the Undo operation
 * @author Shanny Abid,Avigail Gilad.
 */

public class UndoableStringBuilder {
    private StringBuilder st;
    private Stack<String> stack;

    /**
     * empty constructor.
     */
    public UndoableStringBuilder() {
        st = new StringBuilder();
        stack = new Stack<>();
    }

    /**
     *  A constructor that gets a pre-defined string.
     * @param str the string
     */
    public UndoableStringBuilder(String str) {
        st = new StringBuilder(str);
        stack = new Stack<>();
        stack.push(str);
    }

    /**
     * function that append a string to the end.
     * @param str the appended string.
     * @return a reference to the object
     */
    public UndoableStringBuilder append(String str) {
        stack.push(st.toString());
        st.append(str);
        StringBuilder temp = new StringBuilder(st);
        return this;
    }

    /**
     * a function that delete a substring.
     * @param start the first index of the substring we want to delete.
     * @param end the last index of the substring we want to delete.
     * @return a reference to the object
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            stack.push(st.toString());
            st.delete(start, end);
            StringBuilder temp = new StringBuilder(st);

        } catch (Exception e) {
            System.out.println("please enter valid number");
        }
        return this;
    }

    /**
     * a function that insert a string to the current string from specific index.
     * @param offset the specific index where we insert the string.
     * @param str the string we insert.
     * @return a reference to the object
     */

    public UndoableStringBuilder insert(int offset, String str) {
        try {
            stack.push(st.toString());
            st.insert(offset, str);
            StringBuilder temp = new StringBuilder(st);

        } catch (Exception e) {
            System.out.println("please enter valid number");
        }
        return this;
    }

    /**
     * a function that replace a string with a substring from the current string .
     * @param start the first index of the substring we want to replace.
     * @param end the last index of the substring we want to replace.
     * @param str the string we replace.
     * @return a reference to the object
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            stack.push(st.toString());
            st.replace(start, end, str);
            StringBuilder temp = new StringBuilder(st);

        } catch (Exception e) {
            System.out.println("please enter valid number");
        }
        return this;
    }

    /**
     * a function that reverses the elements order in the current string.
     * @return a reference to the object.
     */
    public UndoableStringBuilder reverse() {
        stack.push(st.toString());
        st.reverse();
        StringBuilder temp = new StringBuilder(st);

        return this;
    }

    /**
     *  A method that returns the value given to it in string format.
     * @return the value given in string format.
     */

    @Override
    public String toString() {
        return st.toString();
    }


    /**
     * A method that undo the last operation by using pop method on the stack.
     */
    public  void undo() {
        if( stack.empty()==true){
            System.out.println("the stack is empty");
        }
        else{
            st=new StringBuilder(stack.pop());
        }

    }
}