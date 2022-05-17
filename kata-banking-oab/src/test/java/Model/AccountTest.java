package Model;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;
import transvers.ConstantesBanking;

import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
class AccountTest {

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account(0);
    }

    @Test
    public void testDepositOK() {
        account = new Account(0);
        account.deposit(300);
        int expected = 300;
        Assert.assertEquals(expected, account.getBalance());
    }

    @Test
    public void testDepositTwoTimes() {
        account = new Account(0);
        account.deposit(300);
        account.deposit(500);
        int expected = 300 + 500;
        Assert.assertEquals(expected, account.getBalance());
    }

    @Test
    public void testWithrawOK() {
        account = new Account(0);
        account.deposit(500);
        account.withdraw(300);
        int expected = 500-300;
        Assert.assertEquals(expected, account.getBalance());
    }

    @Test
    public void testDepositAndWithraw() {
        account = new Account(0);
        account.deposit(500);
        account.withdraw(300);
        int expected = 500 - 300;
        Assert.assertEquals(expected, account.getBalance());
    }

    @Test
    public void testWithrawKO() {
        account = new Account(0);
        account.deposit(300);
        Exception exception = assertThrows(BankingException.class,
                () -> account.withdraw(500));
        assertEquals(ConstantesBanking.ERR_MONTANT_DEMANDE_SUP_SOLDE
                , exception.getMessage());
    }

    @Test
    public void testDepositKO() {
        account = new Account(0);
        Exception exception = assertThrows(BankingException.class,
                () -> account.deposit(null));
        assertEquals(ConstantesBanking.MSG_VEUILLEZ_SAISIR_MONTANT
                , exception.getMessage());
    }


}