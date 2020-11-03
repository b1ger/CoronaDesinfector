package com.serena;

public interface ProxyConfigurator {

    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
