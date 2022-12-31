package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private String accountNumber;

    public BankAccount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.balance=balance;
        this.name=name;
        this.minBalance=minBalance;

    }

    public void createAccount(String str, int digit,int sum){
        if(str.length()>=digit){
            int count=0;   //checking its length
            for(int i=0;i<str.length();i++) count+=(str.charAt(i)-'a');
            if(count==sum) this.accountNumber=str;
            return;
        }

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        createAccount("",digits,sum);
        return accountNumber;


    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }
    class InsufficientBalanceException extends RuntimeException{
        public InsufficientBalanceException(String errorMessage){
            super(errorMessage);}
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if(this.balance-amount<minBalance) throw new InsufficientBalanceException("Insufficient Balance");
        else{
            this.balance=this.balance-amount;
        }



    }

}