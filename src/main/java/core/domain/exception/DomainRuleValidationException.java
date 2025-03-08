package core.domain.exception;

public class DomainRuleValidationException extends RuntimeException implements IDomainRuleViolation {
    private final String violationMessage;
    private final String errorCode;

    public DomainRuleValidationException(String message) {
        this(message, IDomainRuleViolation.buildErrorCode("default"));
    }

    public DomainRuleValidationException(String message, String errorCode) {
        super(message);
        this.violationMessage = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getViolationMessage() {
        return violationMessage;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
