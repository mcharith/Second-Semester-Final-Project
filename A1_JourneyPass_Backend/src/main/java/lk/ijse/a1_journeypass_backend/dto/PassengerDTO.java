package lk.ijse.a1_journeypass_backend.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.a1_journeypass_backend.entity.Status;

import java.util.UUID;

public class PassengerDTO {
    private String passengerId;
    private String passengerName;
    private int passengerMobile;
    private String nic;
    private String passengerEmail;
    private Status status;

    public PassengerDTO() {
    }

    public PassengerDTO(String passengerId, String passengerName, int passengerMobile, String nic, String passengerEmail, Status status) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerMobile = passengerMobile;
        this.nic = nic;
        this.passengerEmail = passengerEmail;
        this.status = status;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPassengerMobile() {
        return passengerMobile;
    }

    public void setPassengerMobile(int passengerMobile) {
        this.passengerMobile = passengerMobile;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PassengerDTO{" +
                "passengerId='" + passengerId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", passengerMobile=" + passengerMobile +
                ", nic='" + nic + '\'' +
                ", passengerEmail='" + passengerEmail + '\'' +
                ", status=" + status +
                '}';
    }
}
