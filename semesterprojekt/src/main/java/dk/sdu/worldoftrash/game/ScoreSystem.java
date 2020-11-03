package dk.sdu.worldoftrash.game;

import dk.sdu.worldoftrash.game.data.LevelData;
import dk.sdu.worldoftrash.game.data.ScoreData;
import dk.sdu.worldoftrash.game.data.WasteType;
import dk.sdu.worldoftrash.game.items.Waste;

import java.util.UUID;

public class ScoreSystem {

    private int score;
    private int wasteCount;

    private Client client;

    private ScoreData scoreData;

    private LevelHandler levelHandler;

    public ScoreSystem() {
        this.client = new Client(20, "https://worldoftrash.herokuapp.com");

        this.scoreData = new ScoreData(UUID.randomUUID());
        this.levelHandler = new LevelHandler();

        this.score = 0;
    }

    public void addPoints(int points) {
        setScore(getScore() + points);
    }

    public void givePoints(Waste waste) {
        addPoints(waste.getPoints());

        LevelData levelData = getLevelDataByName(levelHandler.getCurrentLevel());

        levelData.incrementCorrect(waste.getWasteType());
    }

    public void uploadData() {
        client.sendScoreData(scoreData);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementWasteCount(WasteType wasteType) {
        LevelData levelData = getLevelDataByName(levelHandler.getCurrentLevel());
        levelData.incrementWasteCount(wasteType);

        wasteCount++;
        levelHandler.updateCondition(wasteCount);
    }

    /**
     * Get LevelData object of level by given name.
     * If a level by the given name is not found, an entry is created and returned.
     * @param name Name of level
     * @return LevelData object
     */
    public LevelData getLevelDataByName(String name) {
        LevelData levelData = scoreData.getLevelDataByName(levelHandler.getCurrentLevel());

        if (levelData == null) {
            levelData = new LevelData();
            scoreData.addLevelData(levelHandler.getCurrentLevel(), levelData);
        }

        return levelData;
    }

    public LevelHandler getLevelHandler() {
        return levelHandler;
    }

}
