package ru.keebi.TelegramBot.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.keebi.TelegramBot.Entity.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepo extends JpaRepository<Product, Long> {
}
