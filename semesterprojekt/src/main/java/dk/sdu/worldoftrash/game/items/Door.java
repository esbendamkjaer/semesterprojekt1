package dk.sdu.worldoftrash.game.items;

import dk.sdu.worldoftrash.game.Game;
import dk.sdu.worldoftrash.game.rooms.Room;

public class Door extends Item implements Interactable {

    private Room place;
    private Door otherSide;

    public Door(Game game, String name, Room place) {
        super(game, name);
        this.place = place;
    }

    public Room getPlace() {
        return place;
    }

    public void setPlace(Room place) {
        this.place = place;
    }

    public Door getOtherSide() {
        return otherSide;
    }

    public void connect(Door otherSide) {
        this.otherSide = otherSide;
        this.otherSide.otherSide = this;
    }

    @Override
    public void interact(Player player) {
        if (getGame().changeRoom(otherSide.getPlace())) {
            player.moveFromMid(otherSide.getMidPoint());
        }
    }

    @Override
    public void giveItem(Item item, Player player) {
    }
}
