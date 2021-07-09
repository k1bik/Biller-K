package ru.keebi.TelegramBot.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.keebi.TelegramBot.Entity.ClientOrder;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface ClientOrderRepo extends JpaRepository<ClientOrder, Long> {
}
