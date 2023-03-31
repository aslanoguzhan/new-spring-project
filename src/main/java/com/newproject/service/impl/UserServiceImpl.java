package com.newproject.service.impl;

import com.newproject.entity.User;
import com.newproject.repository.UserRepository;
import com.newproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {

        user.setCreatedBy("Admin");
        user.setCreatedData(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
       Optional <User> user= userRepository.findById(id);

       if(user.isPresent()){
             return user.get();
        }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional <User> resulUser= userRepository.findById(id);

        if(resulUser.isPresent()){
            resulUser.get().setFirstName(user.getFirstName());
            resulUser.get().setLastName(user.getLastName());
            resulUser.get().setTcNo(user.getTcNo());
            resulUser.get().setYas(user.getYas());
            resulUser.get().setUpdatedAt(new Date());
            resulUser.get().setUpdatedBy("Admin");
            return userRepository.save(resulUser.get());
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional <User> user= userRepository.findById(id);

        if(user.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
