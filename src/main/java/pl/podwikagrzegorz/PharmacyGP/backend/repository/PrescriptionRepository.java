package pl.podwikagrzegorz.PharmacyGP.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Prescription;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.User;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription, Integer> {
    Prescription findByUser(User user);
}
