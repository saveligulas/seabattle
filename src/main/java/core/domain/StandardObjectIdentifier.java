package core.domain;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.Id;

import java.util.Objects;

@NullMarked
public abstract class StandardObjectIdentifier<T> implements IObjectIdentifier<T> {
    @Nullable
    @Id
    protected T identifier;
    protected Long version;

    public StandardObjectIdentifier(IObjectIdentifier<T> identifier, boolean constructorIdentifier) {
        this(identifier.getIdentifier(), identifier.getVersion());
    }

    public StandardObjectIdentifier() {
        this(null);
    }

    public StandardObjectIdentifier(@Nullable T identifier) {
        this(identifier, 0L);
    }

    public StandardObjectIdentifier(@Nullable T identifier, Long version) {
        this.identifier = identifier;
        this.version = version;
    }

    @Override
    public Long getVersion() {
        return this.version;
    }

    @Override
    public @Nullable T getIdentifier() {
        return this.identifier;
    }

    @Override
    public boolean isPersisted() {
        return IObjectIdentifier.super.isPersisted();
    }

    @Override
    public int hashCode() {
        if (identifier == null) {
            return -1;
        } else {
            return identifier.hashCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StandardObjectIdentifier<?> that)) return false;
        return identifier != null && Objects.equals(identifier, that.identifier);
    }

    @Override
    public String toString() {
        return "Model{" +
                "type=" + this.getClass().getTypeName() +
                "identifier=" + identifier +
                '}';
    }
}
