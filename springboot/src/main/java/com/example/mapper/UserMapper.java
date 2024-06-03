package com.example.mapper;

import com.example.pojo.Params;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User> {

    List<User> findBySearch(@Param("params")Params params);

    //@Select("select * from user")
    List<User> getUser();

    @Select("select * from user where username = #{username} and password = #{password} limit 1")
    User findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    @Select("select * from user where username = #{username} limit 1")
    User findByUsername(@Param("username")String username);

    @Insert("insert into user(username,password,balance,email) values(#{username},#{password},0,#{email})")
    void insertUser(@Param("username")String username,@Param("password")String password,@Param("email")String email);

    @Update("update user set password = #{password} where username = #{username}")
    User changePassword(@Param("username")String username,@Param("password")String password);

    @Update("update user set email = #{email} where username = #{username}")
    User changeEmail(@Param("username")String username,@Param("email")String email);
}
