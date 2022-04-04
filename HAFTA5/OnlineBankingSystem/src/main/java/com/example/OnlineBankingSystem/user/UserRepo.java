package com.example.OnlineBankingSystem.user;

public interface UserRepo {
    int addUser(User user);

    void deleteUser(String tc);

    int updateUser(String  tc, String newName);

    Object getUser(String tc);
}
