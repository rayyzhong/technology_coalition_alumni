package com.coalition.base;

import com.coalition.dto.UserDto;
import com.coalition.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;


/**
 * @Author:abc
 * @Description:
 * @params:$params$
 * @return: $returns$
 * @Date: $date$ $time$
 */

public interface UserRepository extends JpaRepository<User,String> ,Serializable {

//    @Query(value = "")
//    List<User> fuzzyQuery(UserDto userDto);
}
