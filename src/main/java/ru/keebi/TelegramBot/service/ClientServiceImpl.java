package ru.keebi.TelegramBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.keebi.TelegramBot.Entity.Client;
import ru.keebi.TelegramBot.Repos.ClientRepo;
import ru.keebi.TelegramBot.service.interfaces.ClientService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Override
    public List<Client> getAllClients(){
        return clientRepo.findAll();
    }

    @Override
    public Client getClientById(Long id) {

        Client client = new Client();
        client.setId(id);

        return clientRepo.findOne(Example.of(client)).orElse(null);

    }

    @Override
    public Client getClientByName(String name){

        Client client = new Client();
        client.setFullName(name);

        return clientRepo.findOne(Example.of(client)).orElse(null);

    }

}
