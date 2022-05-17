package Model;

import java.io.Serializable;


public class Account implements Serializable {

    private int balance;

    public Account(int initialBalance) {
        balance = initialBalance;
    }


    public Account() {
    }

    public void deposit(Integer amount) throws BankingException{

    }


    /**
     * @return
     */
    public int getBalance() {
        return this.balance;
    }
}


