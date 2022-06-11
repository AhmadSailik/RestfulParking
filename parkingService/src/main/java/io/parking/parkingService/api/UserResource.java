package io.parking.parkingService.api;

import io.parking.parkingService.domain.ParkUser;
import io.parking.parkingService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class UserResource {
    private final UserService userService ;

    @GetMapping("/users")
    public ResponseEntity<List<ParkUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @PostMapping("/user/save")
    public ResponseEntity<ParkUser> saveUser(@RequestBody ParkUser parkUser){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(parkUser));

    }


}
