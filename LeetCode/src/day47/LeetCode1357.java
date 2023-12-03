package day47;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode1357 {
    int n;
    int discount;
    Map<Integer, Integer> map;
    int count = 1;

    public  void Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        map=new LinkedHashMap<>();
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        double sum = 0;
        for (int i = 0; i < amount.length; i++) {
            sum += map.get(product[i]) * amount[i];
        }
        if (count %n  == 0) {
            count++;
            return  sum - (sum * discount ) / 100;
        } else {
            count++;
            return sum;
        }
    }
}
