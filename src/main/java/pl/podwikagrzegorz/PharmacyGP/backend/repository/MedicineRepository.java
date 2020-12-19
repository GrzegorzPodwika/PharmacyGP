package pl.podwikagrzegorz.PharmacyGP.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Medicine;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine, Integer> {
}
