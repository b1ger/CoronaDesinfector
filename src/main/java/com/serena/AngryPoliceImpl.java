package com.serena;

import javax.annotation.PostConstruct;

public class AngryPoliceImpl implements Police {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("I will kill you all!");
    }
}
