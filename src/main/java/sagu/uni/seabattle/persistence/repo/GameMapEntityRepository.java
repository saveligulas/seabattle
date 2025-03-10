package sagu.uni.seabattle.persistence.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import sagu.uni.seabattle.persistence.GameMapEntity;

import java.util.UUID;

@Repository
public interface GameMapEntityRepository extends Neo4jRepository<GameMapEntity, UUID> {
}
