package com.serena;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class  App
{
    public static void main( String[] args )
    {
        // CoronaDesinfector coronaDesinfector = ObjectFactory.getInstance().createObject(CoronaDesinfector.class);

        ApplicationContext context = Application.run("com.serena", new HashMap<>(Map.of(Police.class, AngryPoliceImpl.class)));

        CoronaDesinfector coronaDesinfector = context.getObject(CoronaDesinfector.class);

        coronaDesinfector.start(new Room());
    }
}
