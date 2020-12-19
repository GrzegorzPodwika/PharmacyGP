package pl.podwikagrzegorz.PharmacyGP.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medicine {

    @Id
    @EqualsAndHashCode.Include
    private Integer medicineId;

    private String name;
    private double price;
    private LocalDate expiryDate;
    private boolean isOnPrescription;

    public String getName() {
        return name;
    }

    public boolean isOnPrescription() {
        return isOnPrescription;
    }

    @Override
    public String toString() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
