package com.serena;

public interface Config {

    <T> Class<? extends T> getImplClass(Class<T> type);

    org.reflections.Reflections getScanner();
}
