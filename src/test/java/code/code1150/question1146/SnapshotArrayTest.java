package code.code1150.question1146;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnapshotArrayTest {
    @Test
    public void test1() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        snapshotArray.snap();
        snapshotArray.set(0, 6);
        assertEquals(5, snapshotArray.get(0, 0));
    }
}