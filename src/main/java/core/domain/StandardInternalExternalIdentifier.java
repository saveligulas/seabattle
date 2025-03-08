package core.domain;

import org.jspecify.annotations.Nullable;

import java.util.Objects;

public class StandardInternalExternalIdentifier<IID, EID> extends StandardObjectIdentifier<IID> implements IObjectInternalExternalIdentifier<IID, EID> {
    @Nullable
    protected EID eid;


    public StandardInternalExternalIdentifier(IObjectInternalExternalIdentifier<IID, EID> internalExternalIdentifier) {
        this(internalExternalIdentifier.getIdentifier(), internalExternalIdentifier.getExternalIdentifier(), internalExternalIdentifier.getVersion());
    }

    public StandardInternalExternalIdentifier(@Nullable IID iid, @Nullable EID eid) {
        this(iid, eid, 0L);
    }

    public StandardInternalExternalIdentifier(@Nullable IID iid, @Nullable EID eid, Long version) {
        super(iid, version);
        this.eid = eid;
    }


    @Override
    public @Nullable EID getExternalIdentifier() {
        return this.eid;
    }

    @Override
    public boolean isDomainGenerated() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StandardInternalExternalIdentifier<?, ?> that)) return false;
        return Objects.equals(this.getIdentifier(), that.getIdentifier()) || Objects.equals(this.getExternalIdentifier(), that.getExternalIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eid);
    }
}
