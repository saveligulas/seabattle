package core.persistence.port;

public interface IPersistenceSaveReturnPort<D> {
    D saveReturn(D d);
}
