import lab01.tdd.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList = new CircularListImpl();

    @BeforeEach
    void beforeEach(){
        for(int i=1; i<=3; i++){
            circularList.add(i);
        }
    }

    @Test
    void TestInitiallyEmpty(){
        assertFalse(circularList.isEmpty());
    }

    @Test
    void TestSize(){
        assertEquals(3, circularList.size());
    }

   @Test
    void TestAddElement(){
        circularList.add(1);
        assertEquals(4, circularList.size());
    }

    @Test
    void TestNext(){
        circularList.next();
        assertEquals(2, circularList.next().get());
    }

    @Test
    void TestPrevious(){
        assertEquals(3, circularList.previous().get());
    }

    @Test
    void TestReset(){
        circularList.next();
        circularList.next();
        circularList.reset();
        assertEquals(3,circularList.previous().get());
    }

    @Test
    void TestNextWithStrategy(){
        assertEquals(2,  circularList.next(element -> element%2 == 0).get());
    }
}
