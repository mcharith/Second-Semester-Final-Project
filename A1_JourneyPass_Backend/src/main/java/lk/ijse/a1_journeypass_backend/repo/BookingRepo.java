package lk.ijse.a1_journeypass_backend.repo;

import lk.ijse.a1_journeypass_backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
