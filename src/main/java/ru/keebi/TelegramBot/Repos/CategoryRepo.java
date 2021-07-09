package ru.keebi.TelegramBot.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.keebi.TelegramBot.Entity.Category;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
