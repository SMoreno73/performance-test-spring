package com.riwi.test.infraestructure.services;

import com.riwi.test.api.dto.request.UserRequest;
import com.riwi.test.api.dto.response.UserResponse;
import com.riwi.test.domain.entities.User;
import com.riwi.test.domain.repositories.UserRepository;
import com.riwi.test.infraestructure.abstract_services.IUserService;
import com.riwi.test.infraestructure.mappers.UserMapper;
import com.riwi.test.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        User saveUser = userRepository.save(user);
        return userMapper.toUserResponse(saveUser);
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(userMapper::toUserResponse);
    }

    @Override
    public Optional<UserResponse> getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new IdNotFoundException("USER", id);
        return user.map(userMapper::toUserResponse);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("USER", id));

        userMapper.updateFromUserRequest(userRequest, existingUser);
        User updateUser = userRepository.save(existingUser);
        return userMapper.toUserResponse(updateUser);
    }
}
