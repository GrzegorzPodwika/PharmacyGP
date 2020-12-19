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
public class User {

    @Id
    @EqualsAndHashCode.Include
    private Integer userId;

    private String name;
    private String surname;
    private Integer age;
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
