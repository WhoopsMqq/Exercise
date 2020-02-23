package com.whoops.cloud.security.service.repository;

import com.whoops.cloud.security.service.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("whoops",new User("whoops","123456"));
        userMap.put("moon",new User("moon","123123"));
    }

    public User getUserByUserName(String username){
        return new User("moon","123123");
    }


}
