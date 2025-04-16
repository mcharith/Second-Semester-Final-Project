package lk.ijse.a1_journeypass_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.a1_journeypass_backend.dto.PassengerDTO;
import lk.ijse.a1_journeypass_backend.entity.Passenger;
import lk.ijse.a1_journeypass_backend.entity.Status;
import lk.ijse.a1_journeypass_backend.repo.BusRepo;
import lk.ijse.a1_journeypass_backend.repo.PassengerRepo;
import lk.ijse.a1_journeypass_backend.service.PassengerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepo passengerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addPassenger(PassengerDTO passengerDTO) {
        String id = generatePassengerId();
        passengerDTO.setPassengerId(id);

        // 👇 Set default status if it's not provided
        if (passengerDTO.getStatus() == null) {
            passengerDTO.setStatus(Status.ACTIVE);
        }

        if (passengerRepo.existsById(passengerDTO.getPassengerId())) {
            System.out.println("Passenger already exists : " + passengerDTO.getPassengerId());
            return false;
        }

        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        passenger.setPassengerId(id); // Make sure ID is set
        passengerRepo.save(passenger);
        return true;
    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        return modelMapper.map(passengerRepo.findAll(),
                new TypeToken<List<PassengerDTO>>() {}.getType());

    }

    @Override
    public boolean updatePassengerStatus(String passengerId, Status status) {
        Optional<Passenger> optionalPassenger = passengerRepo.findById(passengerId);
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            passenger.setStatus(status);
            passengerRepo.save(passenger);
            return true;
        }
        return false;
    }

    public String generatePassengerId() {
        Long count = passengerRepo.count() + 1;
        return String.format("PAS%03d", count);
    }
}
