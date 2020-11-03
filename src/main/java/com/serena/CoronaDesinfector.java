package com.serena;

@Deprecated
public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;

    @InjectByType
    private Police police;

    public void start(Room room) {
        announcer.announce("Start desinfection. Get out");
        police.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Risc to come in.");
    }

    private void desinfect(Room room) {
        System.out.println("Desinfect room: " + room.toString());
    }
}
