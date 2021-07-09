package ru.keebi.TelegramBot.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.keebi.TelegramBot.Entity.Client;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientRepo extends JpaRepository<Client, Long> {
}
