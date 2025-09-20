import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];
        
        Map<String, Integer> inCar = new HashMap<>();
        Map<String, Integer> accCar = new HashMap<>();
        
        for (String rec : records) {
            String[] parts = rec.split(" ");
            int time = toMin(parts[0]);
            String carNum = parts[1];
            String active = parts[2];
            
            if (active.equals("IN")) {
                inCar.put(carNum, time);
            }
            else {
                int inTime = inCar.remove(carNum);
                accCar.put(carNum, accCar.getOrDefault(carNum, 0) + (time - inTime));
            }
        }
        
        int endTime = 23 * 60 + 59;
        for (Map.Entry<String, Integer> e : inCar.entrySet()) {
            String carNum = e.getKey();
            int inTime = e.getValue();
            accCar.put(carNum, accCar.getOrDefault(carNum, 0) + (endTime - inTime));
        }
        
        List<String> cars = new ArrayList<>(accCar.keySet());
        Collections.sort(cars);
        int[] answer = new int[cars.size()];
        
        for (int i = 0; i < cars.size(); i++) {
            int totalTime = accCar.get(cars.get(i));
            int fee = calculateFee(totalTime, basicTime, basicFee, perTime, perFee);
            
            answer[i] = fee;
        }
        
        return answer;
    }
    
    public int toMin(String parts) {
        String[] times = parts.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
    
    public int calculateFee(int time, int basicTime, int basicFee, int perTime, int perFee) {
        if (time < basicTime)
            return basicFee;
        
        int extraFee = (((time - basicTime) + perTime - 1) / perTime) * perFee;
        return basicFee + extraFee;
    }
    
}