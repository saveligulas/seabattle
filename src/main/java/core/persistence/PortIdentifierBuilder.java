package core.persistence;

import java.util.List;

public class PortIdentifierBuilder {
    public static String getPortIdentifier(Class<?> genericClass, Class<?> portClass) {
        return getPortIdentifier(List.of(genericClass), portClass);
    }
    public static String getPortIdentifier(List<Class<?>> genericClasses, Class<?> portClass) {
        StringBuilder sb = new StringBuilder();
        for (Class<?> domainClass : genericClasses) {
            sb.append(domainClass.getName());
            sb.append("-");
        }
        sb.append("|")
                .append(portClass.getName());
        return sb.toString();
    }
}
