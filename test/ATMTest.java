

import org.junit.*;
import java.io.*;
import java.util.Vector;
public class AtmTest{
    private ByteArrayOutputStream output = new ByteArrayOutputStream();




    @Test
    public void testfindCombinations() {
        Atm example = new Atm();
        int arr[] = new int[4];
        int[] change = {1, 3};
        Vector res = new Vector<>();
        Vector expected = new Vector();
        example.findCombinationsUtil(arr, change, 0, 4, 4, res);
        Assert.assertEquals("[1, 1, 1, 1, 1, 3]", res.toString());
    }



}

