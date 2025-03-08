package core.domain.exception;

public interface IDomainRuleViolation {
    String getViolationMessage();
    String getErrorCode();
    static String buildErrorCode(String code) {
        return "error.domain." + code;
    }
}
