package com.serena;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> intfcToImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> intfcToImplClass) {
        this.scanner = new Reflections(packageToScan);
        this.intfcToImplClass = intfcToImplClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> intfc) {
        return intfcToImplClass.computeIfAbsent(intfc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(intfc);
            if (classes.size() != 1) {
                throw new RuntimeException(intfc + " has 0 or more than 1 implementation, please update your config.");
            }
            return classes.iterator().next();
        });
    }

}
