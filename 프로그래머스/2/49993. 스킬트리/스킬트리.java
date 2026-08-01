import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int size = skill.length();
        String[] skills = new String[size];
        for (int i = 0; i < size; i++) {
            skills[i] = String.valueOf(skill.charAt(i));
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            String cur_skill = skill_trees[i];
            int step = 0;
            
            for (int j = 0; j < cur_skill.length(); j++) {  
                if (skill.contains(String.valueOf(cur_skill.charAt(j)))) {
                    int idx = Arrays.asList(skills).indexOf(String.valueOf(cur_skill.charAt(j)));
                    if (idx == step) {
                        step++;
                    }
                    else {
                        break;
                    }
                }
                if (j == cur_skill.length() - 1) {
                    answer++;
                }
            }            
        }
        return answer;
    }
}