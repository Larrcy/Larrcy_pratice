package day28.LeetCode2043;

public class Solution {
    long[] balance;

    void Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        //指定账户数量在1-n之间
        //并且取款和转账需要的钱总数小于等于账户余额
        //account1是转出的人
        if (account1 > balance.length || account2 > balance.length || balance[account1 - 1] < money) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > balance.length) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > balance.length || balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }

}
