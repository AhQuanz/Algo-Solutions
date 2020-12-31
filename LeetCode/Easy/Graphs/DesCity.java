/*
This quesiton seems to me like a graph question rather than a string question. (DAG asking to find the node with 0 outgoing edges) 
https://leetcode.com/problems/destination-city/

You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. 
Return the destination city, that is, the city without any path outgoing to another city.
It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"

Input: paths = [["A","Z"]]
Output: "Z"

Input: [["qMTSlfgZlC","ePvzZaqLXj"],["xKhZXfuBeC","TtnllZpKKg"],["ePvzZaqLXj","sxrvXFcqgG"],["sxrvXFcqgG","xKhZXfuBeC"],["TtnllZpKKg","OAxMijOZgW"]]
Output : "OAxMijOZgW"
*/
class DesCity {
    //Use HashMap to check which destination is not a starting point 
    //O(N) Solution 
    HashMap<String,String> map = new HashMap<>();
    for(List<String> path : paths) {
        map.put(path.get(0),path.get(1));
    }
    String res = "";
    for(String v : map.values()) {
        if(map.get(v) == null) {
            res = v;
        }
    }
    return res;
    //Solution 2 - 1 Set (2 pass method) 
    /*
        Set<String> nodes = new HashSet<>();
        for(List<String> path : paths) {
            nodes.add(path.get(0));
        }
        for(List<String> path : paths) {
            if(!nodes.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    */
}
