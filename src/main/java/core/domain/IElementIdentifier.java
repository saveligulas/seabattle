package core.domain;

import org.jspecify.annotations.Nullable;

public interface IElementIdentifier<T> {
    @Nullable T getElementId();
}
