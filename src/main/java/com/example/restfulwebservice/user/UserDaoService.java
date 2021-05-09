package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> Users = new ArrayList<>();

    private static int usersCount = 3;

    static  {
        Users.add(new User(1,"keneth", new Date(),"test1","701010-1111111"));
        Users.add(new User(2,"Alice", new Date(),"test2","801010-2222222"));
        Users.add(new User(3,"Elena", new Date(),"test3","901313-1111111"));
    }

    public List<User> findAll(){
        return Users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }

        Users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user: Users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = Users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
