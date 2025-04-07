package lk.ijse.a1_journeypass_backend.dto;

import lk.ijse.a1_journeypass_backend.entity.Status;

import java.util.UUID;

public class PassengerDTO {
    public UUID uuid;
    public String name;
    public int mobile;
    public String nic;
    public String email;
    public Status status;

    public PassengerDTO(UUID uuid, String name, int mobile, String nic, String email, Status status) {
        this.uuid = uuid;
        this.name = name;
        this.mobile = mobile;
        this.nic = nic;
        this.email = email;
        this.status = status;
    }

    public PassengerDTO() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", mobile=" + mobile +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
