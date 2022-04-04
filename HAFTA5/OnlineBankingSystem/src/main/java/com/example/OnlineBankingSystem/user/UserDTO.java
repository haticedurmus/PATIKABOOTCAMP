package com.example.OnlineBankingSystem.user;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class UserDTO implements UserRepo {

    Set<User> users = new HashSet<>();
    UserRepo userRepo;

    @Override
    public int addUser(User user) {
        if (users.contains(user)) {
            return 0;
        } else {
            users.add(user);
        }
        return 1;
    }

    @Override
    public void deleteUser(String tc) {
        User user = (User) userRepo.getUser(tc);
        if(users.contains(user)){
            users.remove(user);
        }else{
            return;
        }
    }

    @Override
    public int updateUser(String tc, String newName) {
        Iterator<User> itr= users.iterator();

        while (itr.hasNext()){
            if(itr.next().getTc().equals(tc)){
                itr.next().setName(newName);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Object getUser(String tc) {
        return users.stream().filter(user -> user.getTc().equals(tc)).findFirst();
    }
}
