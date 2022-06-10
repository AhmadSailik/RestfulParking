package io.parking.parkingService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class ParkUser {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role>roles=new ArrayList<>();

}
