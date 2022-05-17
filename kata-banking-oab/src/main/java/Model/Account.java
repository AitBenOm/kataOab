package Model;

import transvers.ConstantesBanking;

import java.io.Serializable;
import java.util.Objects;


public class Account implements Serializable {

    private int balance;


    public Account(int initialBalance) {
        balance = initialBalance;
    }

    public void deposit(Integer amount) throws BankingException {

        if (Objects.isNull(amount)) {
            throw new BankingException(ConstantesBanking.MSG_VEUILLEZ_SAISIR_MONTANT);
        }
        this.balance += amount;
    }

    public void withdraw(int amount) throws BankingException {

    }


    /**
     * @return
     */
    public int getBalance() {
        return this.balance;
    }
}


