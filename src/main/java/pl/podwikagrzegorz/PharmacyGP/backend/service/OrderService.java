package pl.podwikagrzegorz.PharmacyGP.backend.service;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import pl.podwikagrzegorz.PharmacyGP.backend.entity.Order;
import pl.podwikagrzegorz.PharmacyGP.backend.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService implements CrudListener<Order> {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
