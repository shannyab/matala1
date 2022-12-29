package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {

        GroupAdmin observerble = new GroupAdmin();
        ConcreteMember Mem1 = new ConcreteMember();

        observerble.register(Mem1);
        observerble.append("starting test");
        assertEquals( "starting test",Mem1.toString());
        observerble.append(" now");
        observerble.undo();
        assertEquals( "starting test",Mem1.toString());
        observerble.delete(5,8);
        assertEquals("start test",Mem1.toString());
        observerble.unregister(Mem1);

    }


    }
