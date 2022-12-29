 In the assigment we studied about  the Observer Design-Pattern and learn how to use it .we build our program using the UndoableStringBuilder class we built. In this assignment for the observer design-pattern- we have one interface for the Sender(observerble interface) and one interface for the Member (observer interface).

The class named GroupAdmin implements the Sender interface. 
the GroupAdmin objects have an ArrayList object which contains all the members that are registered to the GroupAdmin, and have also an object from type UndoableStringBuilder. 
When we want to register a member to the GroupAdmin ,we just add the member to the Arraylist and every modification we do on the UndoableStringBuilder object, the GroupAdmin object will notify all the members in the ArrayList (that are registed to the GroupAdmin) that the UndoableStringBuilder has been modified , and it will update the UndoableStringBuilder object of the members.

The ConcreteMember class implements the Member interface. this class have an update function and a toString function.
The ConcreteMember objects have an UndoableStringBuilder object. 
The toString function is used to represent the UndoableStringBuilder object of the member  as  a string.
 After a ConcreteMember object is registered to a GroupAdmin object, if we change the GroupAdmin's UndoableStringBuilder object,   the GroupAdmin object will send an update to the registered members ,with the Update function that will update their  UndoableStringBuilder object (with shallow copy).

Tests:
we did all the tests with JUnit 5.
In GroupAdmin .Test class we tested all the functions of the GroupAdmin class by creating members and register them to a  GroupAdmin object, making changes on the UndoableStringBuilder object of the GroupAdmin object and see if the update function work correctly and updated the registered members.

In ConcreteMember.Test  class we tested if all the functions : update,toString, worked correctly.

In JvmUtilities tests class, we tested the efficiency of our program with the JvmUtilities class as we were asked in the assignment.

 



