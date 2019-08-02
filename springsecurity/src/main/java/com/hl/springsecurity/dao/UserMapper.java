package com.hl.springsecurity.dao;

import com.hl.springsecurity.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @version V1.0.0
 * @Description
 */
@Mapper
@Component
public interface UserMapper {


    User getUserFromDatabase(@Param("username") String username);

}
