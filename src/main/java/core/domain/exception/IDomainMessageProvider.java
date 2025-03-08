package core.domain.exception;

import org.jspecify.annotations.Nullable;

import java.util.Locale;

/**
 * Resolves Message identifiers and gives you the responding message. Should be used in monolithic applications where
 * the frontend is directly accessible through the Spring Boot application.
 */
public interface IDomainMessageProvider {
    /**
     * Retrieves the message associated with the given identifier.
     *
     * @param domainRuleViolation The violated rule.
     * @param locale The locale to which the message should be translated to. If null, english is used.
     * @return The message.
     * @throws IllegalArgumentException if the identifier from the violation is not valid
     */
    String resolveMessage(IDomainRuleViolation domainRuleViolation, @Nullable Locale locale);
}
