package com.example.OnlineBankingSystem.user;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class User {
    @NonNull
    private String name;

    @NonNull
    private String tc;

    @NonNull
    private String password;

    @NonNull
    private Double balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return tc.equals(user.tc);
    }

    @Override
    public int hashCode() {
        return tc.hashCode();
    }
}
