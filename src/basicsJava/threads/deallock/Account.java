package basicsJava.threads.deallock;

public class Account {
    private int balance = 10000;

    public void depsit(int x) {
        this.balance += x;
    }

    public void withdraw(int x) {
        this.balance -= x;
    }

    public int getBalance() {
        return this.balance;
    }

    public static void transfer(Account a1, Account a2, int ammount) {
        a1.withdraw(ammount);
        a2.depsit(ammount);
    }
}
