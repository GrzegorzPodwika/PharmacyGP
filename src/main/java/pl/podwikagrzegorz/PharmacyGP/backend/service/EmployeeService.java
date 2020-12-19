package pl.podwikagrzegorz.PharmacyGP.backend.service;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Employee;
import pl.podwikagrzegorz.PharmacyGP.backend.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService implements CrudListener<Employee> {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }

    @Override
    public Employee add(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        repo.delete(employee);
    }
}
