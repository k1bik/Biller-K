package ru.keebi.TelegramBot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.keebi.TelegramBot.Entity.ClientOrder;
import ru.keebi.TelegramBot.service.OrderServiceImpl;

import java.util.List;

@RestController
public class RestOrderController {

    private final OrderServiceImpl orderService;

    public RestOrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "rest/orders", params = {"id"})
    public ClientOrder getOrderById(@RequestParam Long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("rest/orders")
    public List<ClientOrder> getAllOrders(){
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "rest/orders", params = {"status"})
    public List<ClientOrder> getTopPopular(@RequestParam Integer status){
        return orderService.getOrdersByStatus(status);
    }

    @RequestMapping(value = "rest/listClientOrders", params = {"name"})
    public List<ClientOrder> getClientOrdersByName(@RequestParam String name){
        return orderService.getClientOrdersByName(name);
    }

}
