package ru.keebi.TelegramBot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.keebi.TelegramBot.Entity.Client;
import ru.keebi.TelegramBot.service.ClientServiceImpl;

import java.util.List;

@RestController
public class RestClientController  {

    private final ClientServiceImpl clientService;

    public RestClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping("rest/clients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @RequestMapping(value = "rest/clients", params = {"name"})
    public Client getClientByName(@RequestParam String name){
        return clientService.getClientByName(name);
    }

    @RequestMapping(value = "rest/clients", params = {"id"})
    public Client getClientById(@RequestParam Long id){
        return clientService.getClientById(id);
    }

}
