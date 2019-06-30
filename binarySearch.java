import java.io.*;
import java.util.*;

class search{

    private int key;

    search(int key){
        this.key = key;
    }

    private boolean p(int x){
        if(x>=key)
            return true;
        else
            return false;
    }

    int greaterThanEqual(int[] arr){
        int low, high, mid;
        low = 0; high = arr.length-1;
        while(low<high){

            mid = low + (high-low)/2;
            if(p(arr[mid]))
                high = mid;
            else
                low = mid+1;
        }

        if(!p(arr[low]))
            return -1;
        return low;
    }

    private boolean p1(int x) {
        if (x <= key)
            return true;
        else
            return false;
    }

    int lessThanEqual(int[] arr){
        int low, high, mid;
        low = 0; high = arr.length-1;
        while(low<high){

            mid = low + (high-low+1)/2;
            if(p1(arr[mid]))
                low = mid;
            else
                high = mid-1;
        }

        if(!p1(arr[low]))
            return -1;
        return low;
    }

}

public class binarySearch {

    public static void main(String[] args) throws Exception{
        BufferedReader rr = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter array elements: ");
        String[] ar = rr.readLine().split(" ");

        int[] ar1 = new int[ar.length];
        for(int i=0; i<ar.length; i++)
            ar1[i] = Integer.parseInt(ar[i]);

        System.out.print("enter value to be searched: ");
        int key;
        key = Integer.parseInt(rr.readLine());

        search obj = new search(key);
        int left = obj.lessThanEqual(ar1);

        int right = obj.greaterThanEqual(ar1);

        if(left == -1 || right == -1)
            System.out.println("Cannot find");

        System.out.println(left - right +1);

    }
}
