package lk.ijse.a1_journeypass_backend.service.impl;

import lk.ijse.a1_journeypass_backend.dto.BookingDTO;
import lk.ijse.a1_journeypass_backend.entity.Booking;
import lk.ijse.a1_journeypass_backend.entity.Bus;
import lk.ijse.a1_journeypass_backend.entity.Passenger;
import lk.ijse.a1_journeypass_backend.entity.Schedule;
import lk.ijse.a1_journeypass_backend.repo.BookingRepo;
import lk.ijse.a1_journeypass_backend.repo.PassengerRepo;
import lk.ijse.a1_journeypass_backend.repo.ScheduleRepo;
import lk.ijse.a1_journeypass_backend.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Override
    @Transactional
    public boolean addBooking(BookingDTO bookingDTO) {
        if (bookingDTO.getBookingId() != null && bookingRepo.existsById(bookingDTO.getBookingId())) {
            System.out.println("Booking already exists: " + bookingDTO.getBookingId());
            return false;
        }

        Passenger passenger = passengerRepo.findById(bookingDTO.getPassengerId())
                .orElseThrow(() -> new RuntimeException("Passenger not found"));

        Schedule schedule = scheduleRepo.findById(bookingDTO.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        Booking booking = new Booking();
        booking.setPassenger(passenger);
        booking.setSchedule(schedule);
        booking.setSeatsNumber(bookingDTO.getSeatsNumber());
        booking.setSeatPrice(bookingDTO.getSeatPrice());
        booking.setBookingStatus(bookingDTO.getBookingStatus());
        booking.setPaymentStatus(bookingDTO.getPaymentStatus());
        booking.setBookedAt(bookingDTO.getBookedAt());

        bookingRepo.save(booking);
        System.out.println("Booking added: " + bookingDTO);
        System.out.println("Booking saved successfully");
        return true;
    }
}
