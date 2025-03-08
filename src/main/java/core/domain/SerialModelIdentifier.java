package core.domain;

public abstract class SerialModelIdentifier extends StandardObjectIdentifier<Long> {
    public SerialModelIdentifier() {
        super();
    }

    public SerialModelIdentifier(Long identifier) {
        super(identifier);
    }

    @Override
    public boolean isDomainGenerated() {
        return false;
    }
}
