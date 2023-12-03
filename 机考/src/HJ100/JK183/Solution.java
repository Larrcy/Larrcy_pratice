package HJ100.JK183;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//***货币单位换算
public class Solution {

    private static final Pattern pNum = Pattern.compile("[0-9]+");
    private static final Pattern pWord = Pattern.compile("([a-z]|[A-Z])+");
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        String[]strs =new String[n];
        for (int i = 0; i < n; i++) {
            strs[i]=sc.nextLine();
        }
    }

    private static int func(String[] input) {
        Map<String, Double> exchange = new HashMap<>();
        exchange.put("CNY", 0.01);
        exchange.put("fen", 1.0);
        exchange.put("JPY", .1825);
        exchange.put("sen", 18.25);
        exchange.put("HKD", 0.0123);
        exchange.put("cents", 1.23);
        exchange.put("EUR", 0.0014);
        exchange.put("eurocents", 0.14);
        exchange.put("GBP", 0.0012);
        exchange.put("pence", 0.12);


        double res = 0.;
        for (String s : input) {
            String str = s;
            String num = "";
            String word = "";
            while (str.length() > 0) {
                Matcher mNum = pNum.matcher(str);
                if (mNum.find()) {
                    num = mNum.group();
                    str = str.substring(num.length());
                }

                Matcher mWord = pWord.matcher(str);
                if (mWord.find()) {
                    word = mWord.group();
                    str = str.substring(word.length());
                }
                res += Double.parseDouble(num) / exchange.get(word);
            }
        }
        return (int) res;
    }
}
