package io.parking.parkingService.service;

import io.parking.parkingService.domain.ParkUser;
import io.parking.parkingService.domain.Role;
import io.parking.parkingService.repo.RoleRepo;
import io.parking.parkingService.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImp implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public ParkUser saveUser(ParkUser parkUser) {
        log.info("Save new user {} to databese",parkUser.getUsername());
        return userRepo.save(parkUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Save new role {} to database",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Add role {} to user {}",roleName,username);
        ParkUser parkUser=userRepo.findByUsername(username);
        Role role=roleRepo.findByName(roleName);
        parkUser.getRoles().add(role);
    }

    @Override
    public ParkUser getUser(String username) {
        log.info("Fetching user {}",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<ParkUser> getUsers() {
        log.info("Fetching all user");
        return userRepo.findAll();
    }
}
