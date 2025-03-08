package core.domain;

import org.jspecify.annotations.Nullable;

public interface IObjectInternalExternalIdentifier<IID, EID> extends IObjectIdentifier<IID> {
    @Nullable EID getExternalIdentifier();
}
