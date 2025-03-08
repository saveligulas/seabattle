package core.domain;

import org.jspecify.annotations.Nullable;

public interface IObjectIdentifier<T> {
    @Nullable T getIdentifier();
    Long getVersion();
    boolean isDomainGenerated();

    /**
     * Checks if the object is persisted. If the identifier is domain generated then this will only validate the version.
     * Else the identifier is checked.
     * @return true if the object is persisted.
     */
    default boolean isPersisted() {
        if (isDomainGenerated()) {
            return getVersion() > 0L;
        }
        return getIdentifier() != null;
    }

    /**
     * Verifies that the version is valid(non-negative).
     * @param version to verify
     * @throws IllegalArgumentException if the version is negative
     */
    default void verifyVersion(Long version) {
        if (version < 0L) {
            throw new IllegalArgumentException("Version must be non negative");
        }
    }
}
