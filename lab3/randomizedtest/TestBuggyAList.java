package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    /*
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> buggy = new BuggyAList<>();
        AListNoResizing<Integer> nr = new AListNoResizing<>();

        buggy.addLast(4); nr.addLast(4);
        buggy.addLast(5); nr.addLast(5);
        buggy.addLast(6); nr.addLast(6);

        assertEquals(buggy.size(), nr.size());
        assertEquals(buggy.removeLast(), nr.removeLast());
        assertEquals(buggy.removeLast(), nr.removeLast());
        assertEquals(buggy.removeLast(), nr.removeLast());
    } */

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                /*
                assertEquals(B.size(), L.size()); */
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    int a = L.getLast();
                    int b = B.getLast();
                    System.out.println("normalGetLast(" + a + ")" + "buggyGetLast(" + b + ")");
                    assertEquals(a, b);
                }
            } else {
                if (L.size() > 0) {
                    int a = L.removeLast();
                    int b = B.removeLast();
                    System.out.println("normalGetLast(" + a + ")" + "buggyGetLast(" + b + ")");
                    assertEquals(a, b);
            }
        }
    }
}}
