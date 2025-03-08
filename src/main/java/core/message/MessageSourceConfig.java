package core.message;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class MessageSourceConfig {
    @Bean
    public CommandLineRunner setDefaultLocale() {
        return args -> {
            Locale.setDefault(Locale.GERMAN);
        };
    }

    @Bean
    public DomainMessagingSource messageSource() {
        DomainMessagingSource messageSource = new DomainMessagingSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
