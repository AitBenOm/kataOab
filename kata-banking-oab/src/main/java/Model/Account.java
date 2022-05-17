package Model;

import transvers.ConstantesBanking;

import java.io.Serializable;
import java.util.*;


public class Account implements Serializable {

    private int balance;



    public Account(int initialBalance) {
        balance = initialBalance;
    }

    public void deposit(Integer amount) throws BankingException{

        if(Objects.isNull(amount)){
            throw new BankingException(ConstantesBanking.MSG_VEUILLEZ_SAISIR_MONTANT);
        }
        this.balance+=amount;
    }

    public void withdraw(int amount) throws BankingException {
        if(Objects.isNull(amount)){
            throw new BankingException(ConstantesBanking.MSG_VEUILLEZ_SAISIR_MONTANT);
        }else if(amount >this.balance){
            throw new BankingException(ConstantesBanking.ERR_MONTANT_DEMANDE_SUP_SOLDE);
        }
        this.balance-=amount;
          }


    /**
     * @return
     */
    public int getBalance() {
        return this.balance;
    }
}


