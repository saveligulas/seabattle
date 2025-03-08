package core.persistence.port;

public interface IPersistenceSavePort<D>{
    void save(D d);
}
