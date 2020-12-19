class ShuffleStr {
    public String restoreString(String s, int[] indices) {
        /*
         * Solution 2 (Character array)  
           char[] arr = new char[indices.length];
            for(int i = 0; i < indices.length; i++) {
                arr[indices[i]] = s.charAt(i);
            }
            return new String(arr);         
        */
        PriorityQueue<duo> PQ = new PriorityQueue<>();
        for(int i = 0; i < indices.length; i++){
            PQ.add(new duo(indices[i],s.charAt(i)));
        }
        StringBuilder result = new StringBuilder();
        while (!PQ.isEmpty()) {
            duo front = PQ.poll();
            result.append(front.letter);
        }
        return result.toString();
    }
}

class duo implements Comparable<duo> {
    public int index;
    public char letter;

    public duo(int index, char letter) {
        this.index = index;
        this.letter = letter;
    }

    public int compareTo(duo other) {
        return this.index - other.index;
    }
}
