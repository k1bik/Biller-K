package ru.keebi.TelegramBot.Repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.keebi.TelegramBot.Entity.OrderProduct;

@RepositoryRestResource(collectionResourceRel = "orderProducts", path = "orderProducts")
public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}
