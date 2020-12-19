package pl.podwikagrzegorz.PharmacyGP.backend.service;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Prescription;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.User;
import pl.podwikagrzegorz.PharmacyGP.backend.repository.PrescriptionRepository;

import java.util.List;

@Service
public class PrescriptionService implements CrudListener<Prescription> {
    private final PrescriptionRepository repo;

    public PrescriptionService(PrescriptionRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Prescription> findAll() {
        return repo.findAll();
    }

    public Prescription find(User user) {
        return repo.findByUser(user);
    }

    @Override
    public Prescription add(Prescription prescription) {
        return repo.save(prescription);
    }

    @Override
    public Prescription update(Prescription prescription) {
        return repo.save(prescription);
    }

    @Override
    public void delete(Prescription prescription) {
        repo.delete(prescription);
    }
}
