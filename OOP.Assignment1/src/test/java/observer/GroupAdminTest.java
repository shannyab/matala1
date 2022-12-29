package observer;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {
    GroupAdmin stam=new GroupAdmin();


    @Test
    void register() {
        GroupAdmin observable1=new GroupAdmin();
        ConcreteMember member1= new ConcreteMember();
        ConcreteMember member2= new ConcreteMember();
        ConcreteMember member3= new ConcreteMember();

        observable1.register(member1);
        observable1.register(member2);
        observable1.register(member3);
        assertEquals("Members: \n" + "M1 - \n" + "M2 - \n" + "M3 - \n" ,observable1.toString());

        observable1.append("hi");

        assertEquals("Members: \n" + "M1 - hi\n" + "M2 - hi\n" + "M3 - hi\n" ,observable1.toString());
    }

    @Test
    void unregister() {
        GroupAdmin observable1=new GroupAdmin();
        ConcreteMember member1= new ConcreteMember();
        ConcreteMember member2= new ConcreteMember();
        ConcreteMember member3= new ConcreteMember();

        observable1.unregister(member1);
        observable1.unregister(member2);
        observable1.unregister(member3);
        assertEquals("Members: \n" ,observable1.toString());
    }

    @Test
    void insert() {
        GroupAdmin observable1=new GroupAdmin();
        ConcreteMember member1= new ConcreteMember();
        ConcreteMember member2= new ConcreteMember();
        ConcreteMember member3= new ConcreteMember();

        observable1.append(" hi this is a test");

        observable1.register(member1);
        observable1.register(member2);
        observable1.register(member3);

        assertEquals("Members: \n" + "M1 - \n" + "M2 - \n" + "M3 - \n" ,observable1.toString());

        observable1.insert(0,"for insert");

        assertEquals("Members: \n" +
                "M1 - for insert hi this is a test\n" +
                "M2 - for insert hi this is a test\n" +
                "M3 - for insert hi this is a test\n" ,observable1.toString());


    }

    @Test
    void append() {
        GroupAdmin observable1=new GroupAdmin();
        ConcreteMember member1= new ConcreteMember();
        ConcreteMember member2= new ConcreteMember();
        ConcreteMember member3= new ConcreteMember();

        observable1.append("hi this is a test");

        observable1.register(member1);
        observable1.register(member2);
        observable1.register(member3);

        assertEquals("Members: \n" + "M1 - \n" + "M2 - \n" + "M3 - \n" ,observable1.toString());

        observable1.append(" for append");

        assertEquals("Members: \n" +
                "M1 - hi this is a test for append\n" +
                "M2 - hi this is a test for append\n" +
                "M3 - hi this is a test for append\n" ,observable1.toString());
    }

    @Test
    void delete() {
        GroupAdmin observable1=new GroupAdmin();
        ConcreteMember member1= new ConcreteMember();
        ConcreteMember member2= new ConcreteMember();
        ConcreteMember member3= new ConcreteMember();

        observable1.append("hi this is a test, please notice me! uwu");

        observable1.register(member1);
        observable1.register(member2);
        observable1.register(member3);

        assertEquals("Members: \n" + "M1 - \n" + "M2 - \n" + "M3 - \n" ,observable1.toString());

        observable1.delete(1,3);

        assertEquals("Members: \n" +
                "M1 - hthis is a test, please notice me! uwu\n" +
                "M2 - hthis is a test, please notice me! uwu\n" +
                "M3 - hthis is a test, please notice me! uwu\n" ,observable1.toString());

        observable1.delete(2,10);

        assertEquals("Members: \n" +
                "M1 - ht test, please notice me! uwu\n" +
                "M2 - ht test, please notice me! uwu\n" +
                "M3 - ht test, please notice me! uwu\n" ,observable1.toString());
    }

    @Test
    void undo() {
        GroupAdmin observable1=new GroupAdmin();
        ConcreteMember member1= new ConcreteMember();
        ConcreteMember member2= new ConcreteMember();
        ConcreteMember member3= new ConcreteMember();

        observable1.append("hi this is a test");

        observable1.register(member1);
        observable1.register(member2);
        observable1.register(member3);

        assertEquals("Members: \n" + "M1 - \n" + "M2 - \n" + "M3 - \n" ,observable1.toString());

        observable1.undo();

        assertEquals("Members: \n" +
                "M1 - \n" +
                "M2 - \n" +
                "M3 - \n" ,observable1.toString());
    }
}