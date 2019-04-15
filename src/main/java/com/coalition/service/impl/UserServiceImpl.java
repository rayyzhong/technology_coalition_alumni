package com.coalition.service.impl;

import com.coalition.base.UserRepository;
import com.coalition.dto.UserDto;
import com.coalition.entity.User;
import com.coalition.service.CoalitionService;
import com.coalition.service.UserService;
import com.coalition.until.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author:abc
 * @Description:
 * @params:$params$
 * @return: $returns$
 * @Date: $date$ $time$
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private IdGenerator idGenerator;


    @Autowired
    private CoalitionService coalitionService;

    @Override
    public boolean add(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        try {
            user.setNominator(coalitionService.fetchNominator(user));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean del(String userId) {
        userRepository.deleteById(userId);
        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    public UserDto sel(String userId) {
        UserDto userDto = new UserDto();
        Optional<User> opUser = userRepository.findById(userId);
        User user = opUser.get();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

//    @Override
//    public List<User> fuzzyQuery(UserDto userDto) {
//        List<User> users = userRepository.fuzzyQuery(userDto);
//        return users;
//    }
}
