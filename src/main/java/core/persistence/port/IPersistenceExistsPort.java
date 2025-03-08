package core.persistence.port;

public interface IPersistenceExistsPort<D, ID> {
    boolean exists(ID id);
}
