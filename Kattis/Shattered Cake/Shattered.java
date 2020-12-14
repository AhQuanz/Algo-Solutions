import java.util.*;
import java.io.*;

// Idea , use HashMap for O(1) searching 
// Use arrayList to store length breath and count 
public class Shattered {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        HashMap<String,IntegerTrio> pieces = new HashMap<>();
        int c_width = fio.nextInt();
        int numPiece = fio.nextInt();

        for(int i = 0; i < numPiece; i++) {
            int p_width = fio.nextInt();
            int p_length = fio.nextInt();
            StringBuilder key1 = new StringBuilder();
            key1.append(p_width);
            key1.append(p_length);
            IntegerTrio value = pieces.get(p_width+""+p_length);
        }
    }
}

class IntegerTrio {
    public int length;
    public int width;
    public int count; 

    public IntegerTrio(int l,int w, int c) {
        this.length = l;
        this.width = w;
        this.count = c;
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




