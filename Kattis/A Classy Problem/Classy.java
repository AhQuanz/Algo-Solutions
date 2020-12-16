import java.util.*;
import java.io.*;


public class Classy {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        PriorityQueue<Person> PQ = new PriorityQueue<>();
        int numTest = fio.nextInt();
        int maxLength = 0;
        for (int i = 0; i < numTest; i++) {
            int numPeople = fio.nextInt();
            for (int j = 0; j < numPeople; j++) {
                String input = fio.nextLine();
                String[] arr = input.split(": ");
                String[] s_class = arr[1].split("-");
                if (maxLength < s_class.length) {
                    maxLength = s_class.length;
                }
                String rank = "";
                for (int y = s_class.length - 1; y >= 0; y--) {
                    switch (s_class[y]){
                        case "middle":
                            rank += 2;
                        case "lower":
                            rank += 1;
                        case "upper":
                            rank += 3;
                    }
                }
                fio.println(rank);
                fio.println(Arrays.toString(arr));
            }
        }
        fio.close();
    }
}

class Person implements Comparable<Person> {
    public String name;
    public int rank;

    public Person(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public int compareTo(Person other) {
        return -1 * (this.rank - other.rank);
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

