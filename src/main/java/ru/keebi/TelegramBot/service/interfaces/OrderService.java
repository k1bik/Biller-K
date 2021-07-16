package ru.keebi.TelegramBot.service.interfaces;

import ru.keebi.TelegramBot.Entity.ClientOrder;

import java.util.List;

/**
 * Сервис для работы с Заказами
 */

public interface OrderService {

    /**
     * Возвращает список всех заказов
     */
    List<ClientOrder> getAllOrders();

    /**
     * Возвращает заказ по его идентификатору
     * @param id идентификатор заказа
     */
    ClientOrder getOrderById(Long id);

    /**
     * Возвращает заказ по его статусу
     * @param status статус заказа
     */
    List<ClientOrder> getOrdersByStatus(Integer status);

    /**
     * Возвращает список заказов клиента по его имени
     * @param name имя клиента
     */
    List<ClientOrder> getClientOrdersByName(String name);

}
