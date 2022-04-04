package com.example.OnlineBankingSystem.checker;

public class IsPasswordProper {

    //password length should equals 4
    public boolean isLengthFour(String password) {
        if (password.length() == 4) {
            return true;
        }
        return false;
    }

    //password does not include birth year. Password shouldnt start with "18..,19..,20..".
    public boolean isIncludeBirthYear(String password) {
        if (password.startsWith("18") || password.startsWith("19") || password.startsWith("20")) {
            return false;
        }
        return true;
    }

}
