package ru.keebi.TelegramBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.keebi.TelegramBot.Entity.ClientOrder;
import ru.keebi.TelegramBot.Repos.ClientOrderRepo;
import ru.keebi.TelegramBot.service.interfaces.OrderService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ClientOrderRepo clientOrderRepo;

    @Override
    public List<ClientOrder> getAllOrders() {
        return clientOrderRepo.findAll();
    }

    @Override
    public ClientOrder getOrderById(Long id) {

        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setId(id);

        return clientOrderRepo.findOne(Example.of(clientOrder)).orElse(null);

    }

    @Override
    public List<ClientOrder> getOrdersByStatus(Integer status) {
        return clientOrderRepo.getOrderByStatus(status);
    }

    @Override
    public List<ClientOrder> getClientOrdersByName(String name) {
        return clientOrderRepo.getClientOrdersByName(name);
    }

}
