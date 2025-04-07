package lk.ijse.a1_journeypass_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.a1_journeypass_backend.dto.PassengerDTO;
import lk.ijse.a1_journeypass_backend.entity.Passenger;
import lk.ijse.a1_journeypass_backend.entity.Status;
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

    @Transactional  // Ensures data consistency
    @Override
    public boolean addPassenger(PassengerDTO passengerDTO) {
        if (passengerDTO.getUuid() == null) {
            passengerDTO.setUuid(UUID.randomUUID());
        }

        if (passengerDTO.getStatus() == null) {
            passengerDTO.setStatus(Status.ACTIVE);
        }

        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        passengerRepo.save(passenger);

        return passengerRepo.existsById(passenger.getUuid());
    }
}
