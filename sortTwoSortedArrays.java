import java.util.*;
import java.io.*;

public class sortTwoSortedArrays {

    private static void sort(int[] ar1, int[] ar2){
        int n, m, j, index;
        m = ar1.length - ar2.length;
        n = ar2.length;
        index = m+n-1;

        for(int i=n-1; i>=0; i--){
            int last;
            last = ar1[m-1];
            for(j=m-2; j>=0 && ar1[j]>ar2[i]; j--){
                ar1[j+1] = ar1[j];
            }

            if(j!=m-2 || last>ar2[i]){
                ar1[j+1] = ar2[i];
                ar1[index--] = last;
            }
            else{
                ar1[index--] = ar2[i];
            }
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader rr = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter array 1 elements: ");
        String[] ar = rr.readLine().split(" ");

        int[] ar1 = new int[ar.length];
        for(int i=0; i<ar.length; i++)
            ar1[i] = Integer.parseInt(ar[i]);

        System.out.print("Enter array 2 elements: ");

        String[] arr = rr.readLine().split(" ");

        int[] ar2 = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            ar2[i] = Integer.parseInt(arr[i]);

        sort(ar1,ar2);

        for(int i=0; i<ar1.length; i++){
            System.out.print(ar1[i]+" ");
        }

    }
}
