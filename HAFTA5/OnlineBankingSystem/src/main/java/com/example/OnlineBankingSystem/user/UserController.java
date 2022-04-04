package com.example.OnlineBankingSystem.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {
    UserService userService;

    @PutMapping("/register")
    public int register(User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public int login(String tc, String password) {
        return userService.login(tc, password);
    }

    @PostMapping("/sendMoney")
    public int sendMoney(String firstUserTc, String secondUserTc, double money) {
        return userService.sendMoney(firstUserTc, secondUserTc, money);
    }

    @PostMapping("/payCreditCardExtre")
    public int payCreditCardExtre(String userTc, double debt) {
        return userService.payCreditCardExtre(userTc, debt);
    }

    @PostMapping("/payCredit")
    public int payCredit(String userTc, double debt) {
        return userService.payCredit(userTc, debt);
    }
}
