package pl.podwikagrzegorz.PharmacyGP.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
}
