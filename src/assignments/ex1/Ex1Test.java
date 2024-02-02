package assignments.ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {

    @BeforeEach
    void setUp() {
    }

    /**
     *  b_p({1,2,3}, {1,3,4}) --> {1,1}
     *  *     b_p({9,9,9,9}, {9,7,1,9} --> {2,0}
     *  *     b_p(2,2,3,8}, {4,7,2,9} --> {0,1}
     *  *     b_p({4,7,2,9} ,{2,2,3,8} --> {0,1}
     */
    @Test
    void test_B() {
        int[] a = {1, 2, 3};
        int[] b = {1, 4, 3,}; //  --> {2,0}
        int[] res = Ex1.b_p(a, b); // should be {2,0};
        int[] expected = {2, 0};
        assertEquals(res[0], expected[0]);
        //   assertEquals(res[1], expected[1]);
    }
    @Test
    void test_B_P() {
        int[] a ={1,2,3};
        int[] b = {1,3,4}; //  --> {1,1}
        int[] res = Ex1.b_p(a,b); // should be {1,1};
        int[] expected ={1,1};
        assertEquals(res[0], expected[0]);
        assertEquals(res[1], expected[1]);
               // *     b_p({9,9,9,9}, {9,7,1,9} --> {2,0}
               // *     b_p(2,2,3,8}, {4,7,2,9} --> {0,1}
     //b_p({4,7,2,9} ,{2,2,3,8} --> {0,1}
    }

    @Test
    void test_B_P1() {
        int[] a = {2,2,3,8};
        int[] b = {4,7,2,9};
        int[] res = Ex1.b_p(a,b); // should be {0,1};
        int[] expected ={0,1};
        assertEquals(res[0], expected[0]);
        assertEquals(res[1], expected[1]);
        res = Ex1.b_p(b,a); // should be {0,1};
        assertTrue(res[0]== 0);
        assertEquals(res[1], 1);
        // *     b_p({9,9,9,9}, {9,7,1,9} --> {2,0}
        // *     b_p(2,2,3,8}, {4,7,2,9} --> {0,1}
        //b_p({4,7,2,9} ,{2,2,3,8} --> {0,1}
    }
}