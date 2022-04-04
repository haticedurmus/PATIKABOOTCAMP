package com.example.OnlineBankingSystem.bank;

import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo {
    Bank getBank();
}
