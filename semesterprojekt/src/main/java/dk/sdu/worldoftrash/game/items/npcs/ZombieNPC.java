package dk.sdu.worldoftrash.game.items.npcs;

import dk.sdu.worldoftrash.game.Game;
import dk.sdu.worldoftrash.game.items.Item;

public class ZombieNPC extends NPC {

    public ZombieNPC(Game game, String name, String dialogue) {
        super(game, name, dialogue);
    }

    @Override
    public void talk() {

    }

    @Override
    public boolean giveItem(Item item) {
        return false;
    }
}