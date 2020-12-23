import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int num_test = fio.nextInt();
        for (int i = 0; i < num_test; i++) {
            int num_name = fio.nextInt();
            String[] original = new String[num_name];
            String[] sorting = new String[num_name];
            for( int j = 0; j < num_name; j++) {
                original[j] = fio.nextLine();
                sorting[j] = original[j];
            }
            Arrays.sort(sorting);
            int count = 0;
            for(int j = 0; j < num_name; j++) {
                if (original[j] != sorting[j]) {
                    count++;
                }
            }
            fio.println("Case #" + (i + 1) + ": " + count/2);
        }
        fio.close();
    }
}


/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}
