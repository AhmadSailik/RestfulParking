package io.parking.parkingService.repo;

import io.parking.parkingService.domain.ParkUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<ParkUser,Long> {
    ParkUser findByUsername(String username);
}
