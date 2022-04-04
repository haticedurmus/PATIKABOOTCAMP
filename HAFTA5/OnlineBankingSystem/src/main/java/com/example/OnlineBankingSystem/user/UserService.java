package com.example.OnlineBankingSystem.user;

import com.example.OnlineBankingSystem.bank.Bank;
import com.example.OnlineBankingSystem.bank.BankRepo;
import com.example.OnlineBankingSystem.checker.IsPasswordProper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    BankRepo bankRepo;
    UserRepo userRepo;

    IsPasswordProper isPasswordProper;

    public int register(User user) {
        //password length longer tha 4 and does not include birth year
        if (isPasswordProper.isLengthFour(user.getPassword()) && isPasswordProper.isIncludeBirthYear(user.getPassword())) {
            return userRepo.addUser(user);
        } else {
            return 0;
        }
    }

    public int login(String tc, String password) {
        User user = (User) userRepo.getUser(tc);

        if (user.getPassword().equals(password)) {
            return 1;
        } else {
            return 0;
        }
    }


    public int sendMoney(String firstUserTc, String secondUserTc, double money) {
        User firstUser = (User) userRepo.getUser(firstUserTc);
        User secondUser = (User) userRepo.getUser(secondUserTc);

        if (firstUser.getBalance() < money) {
            return 0;
        } else {
            firstUser.setBalance(firstUser.getBalance() - money);
            secondUser.setBalance(secondUser.getBalance() + money);
        }

        return 1;
    }


    public int payCreditCardExtre(String userTc, double debt) {
        User user = (User) userRepo.getUser(userTc);
        Bank bank = bankRepo.getBank();
        if (user.getBalance() < debt) {
            return 0;
        } else {
            user.setBalance(user.getBalance() - debt);
            bank.setBudget(bank.getBudget() + debt);
        }
        return 1;
    }

    public int payCredit(String userTc, double debt) {
        User user = (User) userRepo.getUser(userTc);
        Bank bank = bankRepo.getBank();
        if (user.getBalance() < debt) {
            return 0;
        } else {
            user.setBalance(user.getBalance() - debt);
            bank.setBudget(bank.getBudget() + debt);
        }
        return 1;
    }

}
