package com.hitsz.frequency.dao;

import com.hitsz.frequency.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @create 2021-03-17 14:27
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String userName);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);
}
