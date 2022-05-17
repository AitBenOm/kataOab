package Model;

import transvers.ConstantesBanking;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


public class Account implements Serializable {

    private  List<AccountHistoryEntry> operationsBook;
    private int balance;



    public Account(int initialBalance) {
        balance = initialBalance;
        operationsBook = new ArrayList<>();
    }


    public Account() {
    }

    public void deposit(Integer amount) throws BankingException{

        if(Objects.isNull(amount)){
            throw new BankingException(ConstantesBanking.MSG_VEUILLEZ_SAISIR_MONTANT);
        }
        this.balance+=amount;
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        final AccountHistoryEntry operation = new AccountHistoryEntry(OperationTypeEnum.DEPOSIT, cal, amount, this.balance);
        this.operationsBook.add(operation);

    }

    public void withdraw(int amount) throws BankingException {
        if(Objects.isNull(amount)){
            throw new BankingException(ConstantesBanking.MSG_VEUILLEZ_SAISIR_MONTANT);
        }else if(amount >this.balance){
            throw new BankingException(ConstantesBanking.ERR_MONTANT_DEMANDE_SUP_SOLDE);
        }
        this.balance-=amount;
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        final AccountHistoryEntry operation = new AccountHistoryEntry(OperationTypeEnum.WITHDRAWAL, cal, amount, this.balance);
        this.operationsBook.add(operation);
    }

    public List<String> printStatement() {


       return this.operationsBook.stream().map(operation -> {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Date : "+operation.operationDate());
            stringBuilder.append(" -- ");
            stringBuilder.append("Operation : "+operation.operationType());
            stringBuilder.append(" -- ");
            stringBuilder.append("Amount : "+operation.amount());
            stringBuilder.append(" -- ");
            stringBuilder.append("Balance : "+operation.balance());
            return stringBuilder.toString();
        }).collect(Collectors.toList());
    }


    /**
     * @return
     */
    public int getBalance() {
        return this.balance;
    }
}


