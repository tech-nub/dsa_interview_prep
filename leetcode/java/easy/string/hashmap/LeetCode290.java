"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/word-pattern
Time Complexity: O(n)
Space Complexity: O(n)

ALGO:

1. Use HashMaps for saving the mapping of character to word and vice versa.
2. As # of words in s should be equal to pattern length, so iterate through any of those and if mapping is already in HashMaps but it contradicts with current values, then return false.
3. If it is same or does not exist in maps, then add to the maps.

"""

class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split("\s");

        // # of strigs in s array should be same as length of pattern
        if(sArray.length != pattern.length()) {
            return false;
        }
        // Maps to save character to word and vice versa mappings
        HashMap<Character,String> charToWord = new HashMap<>();
        HashMap<String,Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            // If mapping of character to word or vice versa exists
            // but not equal to current values, then return false
            if(charToWord.containsKey(pattern.charAt(i)) && 
                !charToWord.get(pattern.charAt(i)).equals(sArray[i])) {
                return false;
            }
            if(wordToChar.containsKey(sArray[i]) && 
                !wordToChar.get(sArray[i]).equals(pattern.charAt(i))) {
                return false;
            }
            // Else add the mappings in both maps
            charToWord.put(pattern.charAt(i),sArray[i]);
            wordToChar.put(sArray[i],pattern.charAt(i));
        }
        return true;    
    }
}

