import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.logging.Logger;
import org.junit.jupiter.api.Test;



public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    @Test
    public void test(){
        GroupAdmin testJU = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3= new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();

        System.out.println("Test of object totalsize");
        logger.info(()->JvmUtilities.objectTotalSize(testJU, member1, member2, member3,member4));
        System.out.println("Test of object Footprint");
        logger.info(()->JvmUtilities.objectFootprint(testJU, member1, member2, member3,member4));
        testJU.append("hi we are testing");
        logger.info(()->JvmUtilities.objectFootprint(testJU));
        logger.info(()->JvmUtilities.objectTotalSize(testJU));


        System.out.println("Register the members: ");
        testJU.register(member1);
        testJU.register(member2);
        testJU.register(member3);
        testJU.register(member4);
        logger.info(()->JvmUtilities.objectFootprint(testJU));
        logger.info(()->JvmUtilities.objectTotalSize(testJU));

        testJU.insert(1,"now we are inserting"); //will notify

       //Now let's unregister a members and see what's happen to the memory aloccate: ");
        testJU.unregister(member1);
        logger.info(()->JvmUtilities.objectFootprint(testJU));
        logger.info(()->JvmUtilities.objectTotalSize(testJU));

        System.out.println("the information is: ");
        logger.info(() -> JvmUtilities.jvmInfo());

        System.out.println("the memory stats: ");  // prints all the optimal memory nedded for the all program.
        logger.info(()->JvmUtilities.memoryStats(testJU));



    }
}
