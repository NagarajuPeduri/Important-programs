
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class palindromeOfOddLength {

    public static void main(String[] args) throws IOException {
        int test;
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(read.readLine());
        while(test>0){
            int n = Integer.parseInt(read.readLine());
            String s = read.readLine();
            palind obj = new palind();
            System.out.println(obj.palindrome(n, s));
            test--;
        }

    }
}

class palind{

    public long prime[];
    public long fh[];
    public long bh[];

    int palindrome(int n, String str){
        prime = new long[n+1];
        fh = new long[n];
        bh = new long[n];
        int m = 1000000007;

        prime[0] = 1;
        for(int i=1; i<n+1; i++){                     // precomputing prime numbers
            prime[i] = (prime[i-1]%m*11)%m;
        }

        fh[0] = (int)str.charAt(0)*prime[0];        // forward hashing
        for(int i=1; i<n; i++)
            fh[i] = (fh[i-1]%m+((int)str.charAt(i) * prime[i])%m)%m;

        bh[n-1] = (int)str.charAt(n-1) * prime[0];        //backward hashing
        for(int i=n-2; i>-1; i--)
            bh[i] = (bh[i+1]%m + ((int)str.charAt(i) * prime[n-i-1])%m)%m;

        int ans = 1;
        for(int i=0; i<n-1; i++){
            ans = Math.max(ans, binarySearch(str, i, i, n));            // for odd length
            if(str.charAt(i) == str.charAt(i+1))
                ans = Math.max(ans, binarySearch(str, i, i+1, n));           //for even length palindromic substrings
        }
        return ans;

    }

    int binarySearch(String st, int c1, int c2, int n){
        int lo=0, hi=Math.min(c1, n-c2-1);
        while(lo<hi){
            int m = lo + (hi-lo+1)/2;
            if(valid(st, c1-m, c2+m, n))
                lo = m;
            else
                hi = m-1;
        }
        return 2*lo + c2-c1 + 1;
    }

    boolean valid(String st, int x, int y, int n){
        int sf1 = x+1;
        int m = 1000000007;
        int sf2 = n-y;
        int diff = Math.abs(sf1-sf2);
        long f = (fh[y] - ((x!=0)? fh[x-1]: 0) + m)%m;
        long b = (bh[x] - ((y!=(n-1))? bh[y+1]: 0) + m)%m;

        if(sf1>sf2)
            b = (b*prime[diff])%m;
        else
            f = (f*prime[diff])%m;

        if(f==b)
            return true;
        else
            return false;

    }
}