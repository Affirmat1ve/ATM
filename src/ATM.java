import java.util.Scanner;
import java.util.*;

public class ATM {

    //use recurrent algorithm for combinations
    static void findCombinationsUtil(int[] arr, int[] change, int index, int num, int reducedNum, Vector res) {
        // Base condition
        if (reducedNum < 0)
            return;

        // If combination is found, print it
        if (reducedNum == 0) {
            for (int i = 0; i < index; i++) {
                System.out.print(arr[i] + " ");
                res.addElement(arr[i]);
            }
            System.out.println();
            return;
        }
        // Find the previous number stored in arr[]. It helps
        // in maintaining increasing order
        int prev = (index == 0) ? change[0] : arr[index - 1];


        // note loop starts from previous number i.e. at
        // array location index - 1
        for (int k = prev; k <= num; k++) {
            if (check(change, k)) {
                // next element of array is k
                arr[index] = k;
                // call recursively with reduced number
                findCombinationsUtil(arr, change, index + 1, num, reducedNum - k, res);
            }
        }
        return;
    }

    private static boolean check(int[] arr, int toCheckValue) {
        // check if the specified element
        // is present in the array or not
        // using Linear Search method
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;

    }

    /*
    Function to find out all
    combinations of positive
    numbers that add upto given
    number. It uses findCombinationsUtil()
    */
    static void findCombinations(int[] change, int n) {
        // array to store the combinations
        // It can contain max n elements
        int[] arr = new int[n];
        Vector res = new Vector();
        // find all combinations
        findCombinationsUtil(arr, change, 0, n, n, res);
    }

    private static int inputControl(Scanner in) {
        int n = 0;
        try {
            n = in.nextInt();
            if (n < 0) throw new IllegalArgumentException("Invalid input");
        } catch (IllegalArgumentException iae) {
            System.out.print("Invalid input");
            System.exit(0);
        }
        return n;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input an amount of withdrawal: ");
        int withdr = inputControl(in);
        System.out.print("Input quantity of banknote types: ");
        int qnt = inputControl(in);
        System.out.print("Input banknote value: ");
        int[] bnval = new int[qnt];
        for (int i = 0; i < qnt; i++) {
            bnval[i] = inputControl(in);
        }
        Arrays.sort(bnval);

        findCombinations(bnval, withdr);
    }
}