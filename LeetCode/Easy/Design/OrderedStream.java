/*
https://leetcode.com/problems/design-an-ordered-stream/
There is a stream of n (id, value) pairs arriving in an arbitrary order, where id is an integer between 1 and n and value is a string. No two pairs have the same id.
Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion. 
The concatenation of all the chunks should result in a list of the sorted values.
Implement the OrderedStream class:
OrderedStream(int n) Constructs the stream to take n values.
String[] insert(int id, String value) Inserts the pair (id, value) into the stream, 
then returns the largest possible chunk of currently inserted values that appear next in the order.

Input
["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
[[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
Output
[null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
*/
class OrderedStream {
    private String[] arr; 
    private int ptr; 
    
    public OrderedStream(int n) {
        arr = new String[n];
    }
    
    public List<String> insert(int id, String value) {
        arr[--id] = value;
        ArrayList<String> result = new ArrayList<>();
        if (ptr == id) {
            while(ptr < arr.length && arr[ptr] != null) {
                result.add(arr[ptr]);
                ptr++;
            }
        }
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
