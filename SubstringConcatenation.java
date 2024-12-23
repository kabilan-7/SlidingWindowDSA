package slidingwindowproblems;
import java.util.*;
public class SubstringConcatenation {
}
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int wordCount = words.length;
        int wordLength = words[0].length();
        int concatenatedWordLength = wordLength * wordCount;
        Map<String,Integer> wordMap = getFreqOfWords(words);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i <= n - concatenatedWordLength; i++){
            Map<String,Integer> seen = new HashMap<>();
            for(int j = 0; j < wordCount; j++){
                int startIndex = i + j * wordLength;
                String str = s.substring(startIndex, startIndex + wordLength);
                if(!wordMap.containsKey(str)) break;
                seen.put(str,seen.getOrDefault(str,0)+1);
                if(seen.get(str) > wordMap.getOrDefault(str,0)) break;

                if(j + 1 == wordCount) ans.add(i);
            }
        }
        return ans;
    }
    Map<String,Integer> getFreqOfWords(String words[]){
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        return map;
    }
}
