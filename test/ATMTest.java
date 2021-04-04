
import org.junit.Test;
import org.junit.After;

import org.junit.Before;
import org.junit.*;
import java.io.*;
import java.util.Vector;
public class ATMTest{
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testfindCombinationsUtil() {
    }

    @Test
    public void testfindCombinations() {
        ATM example = new ATM();
        int arr[] = new int[4];
        int[] change = {1, 3};
        Vector res = new Vector<>();
        Vector expected = new Vector();
        example.findCombinationsUtil(arr, change, 0, 4, 4, res);
        Assert.assertEquals("[1, 1, 1, 1, 1, 3]", res.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void main() {
    }
}

