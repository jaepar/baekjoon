import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        String k_num = Integer.toString(n, k);
        
        String[] parts = k_num.split("0+");
        
        int count = 0;
        for (String part : parts) {
            if (part.isEmpty())
                continue;
            
            long prime = Long.parseLong(part);
            if (isPrime(prime))
                count++;
        }
        return count;
    }
    
    private boolean isPrime(long x) {
        if (x < 2)
            return false;
        
        if (x == 2)
            return true;
        
        if (x % 2 == 0)
            return false;
        
        long limit = (long)Math.sqrt(x);
        for (long i = 3; i <= limit; i += 2) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}