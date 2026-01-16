package com.imt.mines;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.imt.mines.Bank;
import com.imt.mines.BankAccount;
import com.imt.mines.Person;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    void testAddAndFindAccount_HappyPath() {
        double initialBalance = 100.0;
        double withdrawLimit = 500.0;
        BankAccount newAccount = new BankAccount(initialBalance, withdrawLimit, "16/01/2026", null);

        int generatedAccountNumber = bank.addAccount(newAccount, 0);

        assertEquals(1, generatedAccountNumber, "Le premier compte ajouté devrait avoir l'ID 1");

        BankAccount foundAccount = bank.findAccount(generatedAccountNumber);

        assertNotNull(foundAccount, "La banque devrait retourner un objet compte");
        assertEquals(initialBalance, foundAccount.getBalance(), "Le solde devrait être de 100.0");
    }

    @Test
    void testFindNonExistentAccount_EdgeCase() {
        BankAccount foundAccount = bank.findAccount(999);
        assertNull(foundAccount, "Chercher un compte inexistant doit retourner null");
    }

    @Test
    void testDepositMoney_HappyPath() {
        BankAccount acc = new BankAccount(0.0, 100.0, "date", null);

        acc.depositMoney(50.0);

        assertEquals(50.0, acc.getBalance(), "Le dépôt de 50 doit mettre le solde à 50");
    }

    @Test
    void testDeleteAccount() throws Exception {
        Person alice = new Person("Alice", 'F', 30, 1.65f);
        BankAccount acc = new BankAccount(100.0, 500.0, "16/01/2026", alice);
        int accNum = bank.addAccount(acc, 0);

        assertNotNull(bank.findAccount(accNum));

        bank.deleteAccount(accNum);

        assertNull(bank.findAccount(accNum), "Le compte devrait avoir été supprimé");
    }
}