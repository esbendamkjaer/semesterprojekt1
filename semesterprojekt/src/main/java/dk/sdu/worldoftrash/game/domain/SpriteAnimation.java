package dk.sdu.worldoftrash.game.domain;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpriteAnimation {

    private Image image;

    private int colWidth;
    private int rowHeight;

    private double speed;

    private int row;
    private int cols;

    private double count = 0;

    /**
     * @param path Resource path to sprite sheet.
     * @param colWidth Width of a column.
     * @param rowHeight Height of a coulumn.
     * @param speed Frame rate.
     */
    public SpriteAnimation(String path, int colWidth, int rowHeight, double speed) {
        this(Img.load(path), colWidth, rowHeight, speed);
    }

    public SpriteAnimation(Image image, int colWidth, int rowHeight, double speed) {
        this.image = image;
        this.colWidth = colWidth;
        this.rowHeight = rowHeight;
        this.speed = speed;
    }

    public void tick(double delta) {
        count = count % cols + speed * delta;
    }

    public void drawImage(GraphicsContext gc, double x, double y, double width, double height) {
        int index = (int) count;
        int sx = index * colWidth;
        int sy = row * rowHeight;

        gc.drawImage(image, sx, sy, colWidth, rowHeight, x, y, width, height);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getColWidth() {
        return colWidth;
    }

    public int getRowHeight() {
        return rowHeight;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
