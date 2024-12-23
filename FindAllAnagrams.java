package slidingwindowproblems;
import java.util.*;
//Given two strings s and p, return an array of all the start indices of p's
//anagrams
// in s. You may return the answer in any order.
//
//
//
//Example 1:
//
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
//Example 2:
//
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
//
//
//Constraints:
//
//1 <= s.length, p.length <= 3 * 104
//s and p consist of lowercase English letters.
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(char c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int isMatch = 0;
        int ws = 0;
        for(int we = 0; we < s.length(); we++){
            char ch = s.charAt(we);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) - 1);
                if(map.get(ch) == 0) isMatch++;
            }
            if(isMatch == map.size()){
                ans.add(ws);
            }
            if(we >= p.length() - 1){
                char c = s.charAt(ws);
                if(map.containsKey(c)){
                    if(map.get(c) == 0) isMatch--;
                    map.put(c,map.get(c)+1);

                }
                ws++;
            }
        }
        return ans;
    }
}
