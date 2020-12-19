package pl.podwikagrzegorz.PharmacyGP.backend.service;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.User;
import pl.podwikagrzegorz.PharmacyGP.backend.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements CrudListener<User> {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }
}
