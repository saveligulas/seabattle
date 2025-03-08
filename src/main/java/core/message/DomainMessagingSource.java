package core.message;

import org.jspecify.annotations.Nullable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import sg.spring.core.domain.exception.IDomainRuleViolation;
import sg.spring.core.domain.exception.IDomainMessageProvider;

import java.util.Locale;

public class DomainMessagingSource extends ReloadableResourceBundleMessageSource implements IDomainMessageProvider {
    @Override
    public String resolveMessage(IDomainRuleViolation domainRuleViolation, @Nullable Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        try {
            return this.getMessage(domainRuleViolation.getErrorCode(), null, locale);
        } catch (NoSuchMessageException e) {
            return this.getMessage("default.message", null, locale);
        }

    }
}
