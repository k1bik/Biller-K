package ru.keebi.TelegramBot.service.interfaces;

import ru.keebi.TelegramBot.Entity.Client;

import java.util.List;

/**
 * Сервис для работы с Клиентами
 */

public interface ClientService {

    /**
     * Возвращает список всех клиентов
     */
    List<Client> getAllClients();

    /**
     * Возвращает клиента по его идентификатору
     * @param id идентификатор клиента
     */
    Client getClientById(Long id);

    /**
     * Возвращает клиента по его имени
     * @param name имя клиента
     */
    Client getClientByName(String name);

}
