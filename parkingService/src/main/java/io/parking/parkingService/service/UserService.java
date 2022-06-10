package io.parking.parkingService.service;

import io.parking.parkingService.domain.ParkUser;
import io.parking.parkingService.domain.Role;

import java.util.List;

public interface UserService {
    ParkUser saveUser(ParkUser parkUser);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    ParkUser getUser(String username);
    List<ParkUser>getUsers();

}
