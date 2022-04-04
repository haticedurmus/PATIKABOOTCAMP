package com.example.OnlineBankingSystem.bank;

import org.springframework.stereotype.Repository;

@Repository
public class BankDTO implements BankRepo {
    Bank bank;

    public BankDTO() {
        this.bank = new Bank(10.000);
    }

    public BankDTO(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Bank getBank() {
        return bank;
    }

}
