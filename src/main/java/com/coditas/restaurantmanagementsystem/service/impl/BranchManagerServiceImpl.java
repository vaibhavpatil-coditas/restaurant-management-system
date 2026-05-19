package com.coditas.restaurantmanagementsystem.service.impl;

import com.coditas.restaurantmanagementsystem.dto.DishRequestDto;
import com.coditas.restaurantmanagementsystem.dto.request.BranchManagerRegistrationRequest;
import com.coditas.restaurantmanagementsystem.dto.response.BranchManagerRegistrationResponse;
import com.coditas.restaurantmanagementsystem.dto.response.DishResponseDto;
import com.coditas.restaurantmanagementsystem.entity.Branch;
import com.coditas.restaurantmanagementsystem.entity.Dish;
import com.coditas.restaurantmanagementsystem.entity.User;
import com.coditas.restaurantmanagementsystem.enums.Role;
import com.coditas.restaurantmanagementsystem.mapper.BranchMapper;
import com.coditas.restaurantmanagementsystem.mapper.DishMapper;
import com.coditas.restaurantmanagementsystem.mapper.UserMapper;
import com.coditas.restaurantmanagementsystem.repository.BranchRepository;
import com.coditas.restaurantmanagementsystem.repository.UserRepository;
import com.coditas.restaurantmanagementsystem.service.BranchManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchManagerServiceImpl implements BranchManagerService {

    private final UserMapper userMapper;
    private final BranchMapper branchMapper;
    private final DishMapper dishMapper;
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public BranchManagerRegistrationResponse register(BranchManagerRegistrationRequest request) {
        User user = userMapper.toUser(request.getUser());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.BRANCH_MANAGER);
        if(user.getUsername().isEmpty())
            user.setUsername(user.getUsername().split("@")[0]);
        Branch branch = branchMapper.toBranch(request.getBranch());
        branch.setBranchManager(user);
        User savedUser = userRepository.save(user);
        Branch savedBranch = branchRepository.save(branch);
        return BranchManagerRegistrationResponse.builder()
                .user(userMapper.toUserResponseDto(savedUser))
                .branch(branchMapper.toBranchResponseDto(savedBranch))
                .build();
    }

    @Override
    public DishResponseDto addDish(DishRequestDto dishRequestDto) {
        Dish dish = dishMapper.toDish(dishRequestDto);

        return null;
    }
}
