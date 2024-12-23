package slidingwindowproblems;
import java.util.*;
public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n - 10 + 1; i++){
            String str = s.substring(i,i+10);
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(String temp : map.keySet()){
            if(map.get(temp) > 1){
                ans.add(temp);
            }
        }
        return ans;
    }


}