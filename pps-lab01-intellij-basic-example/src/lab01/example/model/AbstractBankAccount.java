package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;

    public AbstractBankAccount( AccountHolder holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if(checkUser(userID)){
            this.balance = this.balance + amount - getFee();
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if(checkUser(userID) && isWithdrawAllowed(amount)){
            this.balance = this.balance - amount - getFee();
        }
    }

    protected boolean checkUser(int userID) {
        return this.holder.getId() == userID;
    }

    protected boolean isWithdrawAllowed(double amount) {
        return this.balance >= amount;
    }

    abstract double getFee();
}
