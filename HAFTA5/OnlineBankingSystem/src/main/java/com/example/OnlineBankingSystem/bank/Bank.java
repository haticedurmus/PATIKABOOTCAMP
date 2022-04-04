package com.example.OnlineBankingSystem.bank;

import com.example.OnlineBankingSystem.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Bank {
    private Double budget;

    Set<User> users = new HashSet<>();

    public Bank(Double budget) {
        this.budget = budget;
    }
}

