package day29.LeetCode1396;



import java.util.*;

public class Solution {
   /* // mapIn记录入站信息，键为顾客id，值为（入站名称，入站时间）
    Map<Integer, Pair<String, Integer>> mapIn = new HashMap<>();

    //mapOut记录出站信息，键为（startStationName,endStationName） 值为（消耗的总时间，出入站的人数）
    Map<String, int[]> mapOut = new HashMap<>();

    void UndergroundSystem() {

    }

    // 入站记录信息直接插入
    public void checkIn(int id, String stationName, int t) {
        mapIn.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        //以开始和结束站名组成唯一键
        String keyStation = mapIn.get(id).getKey() + "-" + stationName;
        int timeCost = t - mapIn.get(id).getValue(); // 此次入站到出站消耗的时间

        int cnt = mapOut.getOrDefault(keyStation, new int[]{0, 0})[1] + 1;  // 人数加一
        int time = mapOut.getOrDefault(keyStation, new int[]{0, 0})[0] + timeCost;  // 耗时叠加
        mapOut.put(keyStation, new int[]{time, cnt});  //记录在map中

    }

    public double getAverageTime(String startStation, String endStation) {
        String keyStation = startStation + "-" + endStation;
        int[] data = mapOut.get(keyStation);
        double ans = (double) data[0] / data[1];  //**注意强制转化为double类型
        return ans;
    }
*/
}
