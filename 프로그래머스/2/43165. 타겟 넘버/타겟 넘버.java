class Solution {
    
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(0, numbers, target, 0);
        
        return(cnt);
    }
    
    private void dfs(int idx, int[] nums, int target, int sum) {
        
        if (idx == nums.length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }
        
        int plus = sum + nums[idx];
        int minus = sum - nums[idx];
        
        dfs(idx + 1, nums, target, plus);
        dfs(idx + 1, nums, target, minus);        
    }
    
}