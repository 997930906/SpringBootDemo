package cn.whu.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.whu.entity.User;

public interface UserMapper {
	@Select("select * from user where username=#{username}")
	User findByName(@Param("username") String username);
}
