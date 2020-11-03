package dk.sdu.worldoftrash.game.items;

import dk.sdu.worldoftrash.game.Game;
import dk.sdu.worldoftrash.game.data.WasteType;

public class Waste extends Pickupable {
    private WasteType wasteType;
    private int points;
    private String wrongSorting;
    private boolean clean;

    public Waste(Game game, String name, WasteType wasteType, String wrongSorting, boolean clean) {
        super(game, name);
        this.wasteType = wasteType;
        this.wrongSorting = wrongSorting;
        this.clean = clean;
        this.points = 1;
    }

    public WasteType getWasteType(){
        return wasteType;
    }

    public int getPoints(){
        return this.points;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public String getWrongSorting() {
        return wrongSorting;
    }
}
