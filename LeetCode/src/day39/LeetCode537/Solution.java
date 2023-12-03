package day39.LeetCode537;

public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] split1 = num1.split("\\+");
        String[] split2 = num2.split("\\+");
        int a =Integer.parseInt(split1[0]);
        int b=0;
        if(split1[1].startsWith("-")){
            b= -Integer.parseInt(split1[1].substring(1, split1[1].length()-1));
        }else {
            b=Integer.parseInt(split1[1].substring(0, split1[1].length()-1));
        }
        int c =Integer.parseInt(split2[0]);
        int d =0;
        if(split2[1].startsWith("-")){
            d= -Integer.parseInt(split2[1].substring(1, split2[1].length()-1));
        }else {
            d=Integer.parseInt(split2[1].substring(0, split2[1].length()-1));
        }
        int sum1 =a*c-b*d;
        int sum2=a*d+b*c;
        StringBuilder sb =new StringBuilder();
      return   sb.append(sum1).append("+").append(sum2).append("i").toString();
    }
}
