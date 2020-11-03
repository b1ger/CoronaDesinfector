package com.serena;

public class PoliceImpl implements Police {

    @InjectByType
    private Recommendator recommendator;

    public PoliceImpl() {
        // System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Get out, I will shoot!");
    }

}
