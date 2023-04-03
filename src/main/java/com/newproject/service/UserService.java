package com.newproject.service;

import com.newproject.dto.UserDto;
import com.newproject.entity.User;
import com.newproject.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    List<UserDto> getUsers();
    User getUser(Long id);

    User updateUser(Long id ,User user);
   Boolean deleteUser(Long id);

   Page<User> pagination (int currentPage, int pageSize);

    Page<User> pagination(Pageable pageable);
   Slice<User> slice(Pageable pageable);

   CustomPage<UserDto> customPagination (Pageable pageable);
}
