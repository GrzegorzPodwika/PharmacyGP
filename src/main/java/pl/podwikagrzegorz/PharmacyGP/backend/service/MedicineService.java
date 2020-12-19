package pl.podwikagrzegorz.PharmacyGP.backend.service;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Medicine;
import pl.podwikagrzegorz.PharmacyGP.backend.repository.MedicineRepository;

import java.util.List;

@Service
public class MedicineService implements CrudListener<Medicine> {
    private final MedicineRepository repo;

    public MedicineService(MedicineRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Medicine> findAll() {
        return repo.findAll();
    }

    @Override
    public Medicine add(Medicine medicine) {
        return repo.save(medicine);
    }

    @Override
    public Medicine update(Medicine medicine) {
        return repo.save(medicine);
    }

    @Override
    public void delete(Medicine medicine) {
        repo.delete(medicine);
    }
}
