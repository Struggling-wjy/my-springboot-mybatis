package com.example.myspringbootmybatis.mapper;

import com.example.myspringbootmybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface  UserMapper {
    @Select("select * from user where id=#{item}")//item可以任意替换
    public User findUserById(Integer id);

    //模糊查询
//  @Select("select * from user where username like CONCAT(#{username},'%')")
    @Select("select * from user where username like '%${username}%'")
    public List<User> selectbyname(String username);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void insert(User user);

    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
//    @Update("update user set(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})where id=#{id}")
    public int updateUserById(User user);

    @Delete("delete from user where id=#{id}")
    public int deleteUserById(Integer id);

    @Select("select * from user")
    public List<User> selectAll();

}
