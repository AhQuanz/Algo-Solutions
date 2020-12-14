import java.util.*;
import java.io.*;

//https://nus.kattis.com/sessions/fz8qek/problems/exactlyelectrical

public class Electrical {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int original_x = fio.nextInt();
        int original_y = fio.nextInt();
        int end_x = fio.nextInt();
        int end_y = fio.nextInt();
        int steps = fio.nextInt();
        
        // Idea is calculate distance then check if it is reachable
        // By taking distance - steps and mod 2 so that we can always take a detour and go back. 
        int distance = Math.abs(original_x - end_x) + Math.abs(original_y - end_y);

        if (distance <= steps && (distance - steps) % 2 == 0) {
            fio.println("Y");
        } else {
            fio.println("N");
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



