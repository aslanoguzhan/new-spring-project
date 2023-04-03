package com.newproject.service.impl;

import com.newproject.advice.UserNotFound;
import com.newproject.dto.UserDto;
import com.newproject.entity.User;
import com.newproject.repository.UserRepository;
import com.newproject.service.UserService;
import com.newproject.util.CustomPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
       User user=modelMapper.map(userDto,User.class);
        user.setCreatedBy("Admin");
        user.setCreatedData(new Date());
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users=userRepository.findAll();
        List<UserDto> dtos=users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public User getUser(Long id) {
       Optional <User> user= userRepository.findById(id);

       if(user.isPresent()){
             return user.get();
        }
        throw new RuntimeException("Kullanıcı Bulunamadı.");
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

    @Override
    public Page<User> pagination(int currentPage, int pageSize) {

        Pageable pageable= PageRequest.of(currentPage,pageSize);
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> pagination(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Slice<User> slice(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public CustomPage<UserDto> customPagination(Pageable pageable) {
        Page<User> data= userRepository.findAll(pageable);

        UserDto[] dtos=modelMapper.map(data.getContent(),UserDto[].class);

        return new CustomPage<UserDto>(data, Arrays.asList(dtos));
    }
}
