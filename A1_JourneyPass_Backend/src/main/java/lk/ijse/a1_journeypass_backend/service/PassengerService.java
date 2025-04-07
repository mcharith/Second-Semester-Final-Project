package lk.ijse.a1_journeypass_backend.service;

import lk.ijse.a1_journeypass_backend.dto.BusDTO;
import lk.ijse.a1_journeypass_backend.dto.PassengerDTO;

public interface PassengerService {
    boolean addPassenger(PassengerDTO passengerDTO);
}
