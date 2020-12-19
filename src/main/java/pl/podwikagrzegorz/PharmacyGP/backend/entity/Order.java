package pl.podwikagrzegorz.PharmacyGP.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @Id
    @EqualsAndHashCode.Include
    private Integer orderId;

    private Employee employee;
    private User user;
    private Set<Medicine> drugs;
    private double sumOfPurchase;
    private LocalDate purchaseDate;

    public Order(Integer orderId, Employee employee, User user, Set<Medicine> drugs, double sumOfPurchase, LocalDate purchaseDate) {
        this.orderId = orderId;
        this.employee = employee;
        this.user = user;
        this.drugs = drugs;
        this.sumOfPurchase = sumOfPurchase;
        this.purchaseDate = purchaseDate;
    }
}
