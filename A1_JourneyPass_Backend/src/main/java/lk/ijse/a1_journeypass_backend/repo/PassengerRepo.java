package lk.ijse.a1_journeypass_backend.repo;

import lk.ijse.a1_journeypass_backend.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PassengerRepo extends JpaRepository<Passenger, String> {
    Passenger findByPassengerName(String passengerName);
}
