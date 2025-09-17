class Solution {
    
    int result_count = 0;
    int result_price = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] sale = new int[emoticons.length];
        
        func1(sale, 0, users, emoticons);
        
        int[] answer = {result_count, result_price};
        
        return answer;
    }
    
    public void func1(int[] sale, int idx, int[][] users, int[] emoticons) {
        if (idx == sale.length) {
            func2(sale, users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i+=10) {
            sale[idx] = i;
            func1(sale, idx + 1, users, emoticons);
        }
    }
    
    public void func2(int[] sale, int[][] users, int[] emoticons) {
        int count = 0;
        int price = 0;
        
        for (int[] user : users) {
            int user_sale = user[0];
            int user_price = user[1];
            int sum = 0;
            
            for (int i = 0; i < sale.length; i++) {
                if (sale[i] >= user_sale)
                    sum += (emoticons[i]/100) * (100 - sale[i]);
            }
            
            if (sum >= user_price)
                count++;
            else
                price += sum;
        }
        
        if (count > result_count) {
            result_count = count;
            result_price = price;
            return;
        }
        else if (count == result_count) {
            if (result_price < price)
                result_price = price;
        }
        
    }
    
}