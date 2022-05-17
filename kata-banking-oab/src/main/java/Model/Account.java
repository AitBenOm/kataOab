package Model;

import transvers.ConstantesBanking;

import java.io.Serializable;
import java.util.*;


public class Account implements Serializable {

    private int balance;

    public Account(int initialBalance) {
        balance = initialBalance;
    }


    public Account() {
    }

    public void deposit(Integer amount) throws BankingException{

        if(Objects.isNull(amount)){
            throw new BankingException(ConstantesBanking.MSG_VEUILLEZ_SAISIR_MONTANT);
        }
        this.balance+=amount;
    }


    /**
     * @return
     */
    public int getBalance() {
        return this.balance;
    }
}


