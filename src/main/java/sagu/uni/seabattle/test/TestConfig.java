package sagu.uni.seabattle.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sagu.uni.seabattle.persistence.GameMapEntity;
import sagu.uni.seabattle.persistence.repo.GameMapEntityRepository;

import java.util.UUID;

@Configuration
public class TestConfig {
    @Bean
    public CommandLineRunner commandLineRunner(@Autowired GameMapEntityRepository gameMapEntityRepository) {
        return args -> {
            GameMapEntity gameMapEntity = new GameMapEntity(UUID.randomUUID());
            gameMapEntityRepository.save(gameMapEntity);
        };
    }

}
