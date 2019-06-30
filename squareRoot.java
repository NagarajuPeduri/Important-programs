import java.util.*;
import java.io.*;

public class squareRoot {

    static double square_root(double x) {
        double lo = 0, hi = x, mid;
        double precision = 1e-9;
        while (hi-lo>precision) {
            mid = lo + (hi-lo)/2;
            if (mid*mid > x)
                hi = mid;
            else
                lo = mid;
        }
        return lo;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader rr = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number: ");
        int number = Integer.parseInt(rr.readLine());
        System.out.println(square_root(number));
    }
}
