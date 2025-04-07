package lk.ijse.a1_journeypass_backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Passenger implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    public String name;
    public int mobile;
    public String nic;
    public String email;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

//    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Booking> bookings;

    @PrePersist
    public void generateUUID() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID();
        }
    }

    public Passenger() {
    }

    public Passenger(UUID uuid, String name, int mobile, String nic, String email, Status status, List<Booking> bookings) {
        this.uuid = uuid;
        this.name = name;
        this.mobile = mobile;
        this.nic = nic;
        this.email = email;
        this.status = status;
//        this.bookings = bookings;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    public List<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }

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

    @Override
    public String toString() {
        return "Passenger{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", mobile=" + mobile +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
//                ", bookings=" + bookings +
                '}';
    }
}
