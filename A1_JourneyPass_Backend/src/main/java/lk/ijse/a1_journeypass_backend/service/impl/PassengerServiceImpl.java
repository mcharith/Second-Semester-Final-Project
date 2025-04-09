package lk.ijse.a1_journeypass_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.a1_journeypass_backend.dto.PassengerDTO;
import lk.ijse.a1_journeypass_backend.entity.Passenger;
import lk.ijse.a1_journeypass_backend.entity.Status;
import lk.ijse.a1_journeypass_backend.repo.BusRepo;
import lk.ijse.a1_journeypass_backend.repo.PassengerRepo;
import lk.ijse.a1_journeypass_backend.service.PassengerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepo passengerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addPassenger(PassengerDTO passengerDTO) {
        if (passengerRepo.existsById(passengerDTO.getPassengerId())) {
            System.out.println("Passenger already exists : " + passengerDTO.getPassengerId());
            return false;
        }
        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        passengerRepo.save(passenger);
        return true;
    }
}
