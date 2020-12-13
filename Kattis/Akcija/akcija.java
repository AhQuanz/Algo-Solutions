/*
    https://nus.kattis.com/problems/akcija
    idea - is to sort array and pair the expensive books in sets of 3
*/
import java.io.*;
import java.util.*;

class akcija {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numTest = fio.nextInt();
        int[] book = new int[numTest];
        int totalCost = 0;

        for(int i = 0; i < numTest; i++) {
            book[i] = fio.nextInt();
            totalCost += book[i];
        }
        Arrays.sort(book);

        int numSets = numTest / 3;
        for (int i = numTest - 3; i >= 0; i -= 3) {
            totalCost -= book[i];
        }

        fio.println(totalCost);
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


