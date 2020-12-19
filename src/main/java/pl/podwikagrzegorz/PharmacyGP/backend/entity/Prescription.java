package pl.podwikagrzegorz.PharmacyGP.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prescription {

    @Id
    @EqualsAndHashCode.Include
    private Integer prescriptionId;

    private UUID uniqueNumber = UUID.randomUUID();
    private User user;
    private Set<Medicine> drugs;

    public Prescription(Integer prescriptionId, UUID uniqueNumber, User user, Set<Medicine> drugs) {
        this.prescriptionId = prescriptionId;
        this.user = user;
        this.drugs = drugs;
    }

    public Prescription(Integer prescriptionId, User user, Set<Medicine> drugs) {
        this.prescriptionId = prescriptionId;
        this.user = user;
        this.drugs = drugs;
    }

    public Set<Medicine> getDrugs() {
        return drugs;
    }
}
