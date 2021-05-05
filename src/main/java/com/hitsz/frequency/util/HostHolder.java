package com.hitsz.frequency.util;

import com.hitsz.frequency.entity.User;
import org.springframework.stereotype.Component;

/**
 * 容器作用，持有用户信息，用于代替session对象。
 * @author yang
 * @create 2021-03-21 10:38
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users=new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }

}
