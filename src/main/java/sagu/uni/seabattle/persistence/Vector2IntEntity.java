package sagu.uni.seabattle.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
//@Node
public class Vector2IntEntity {
    private Integer x;
    private Integer y;
}
