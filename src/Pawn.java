import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Pawn extends ImageView implements ChessPiece  {
    private Image image;
    private Color color;
    private int xPosition, yPosition;

    public Pawn(Image image, Color color, int position){
        super(image);
        this.image = image;
        this.color = color;
        findPositionCoordinates(position);
    }

    /**
     * Returns the color of this instance
     * @return
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets the x and y coordinates based on the position in ObservableList in tilePane
     * @param position
     */
    public void findPositionCoordinates(int position){
        yPosition = position / 8;
        double difference = position / 8.0;
        double fractionalPart = (difference - (int)difference) * 8;
        xPosition = (int)fractionalPart;
    }

    /**
     * Returns the x positional coordinate
     * @return
     */
    public int getxPosition(){
        return this.xPosition;
    }

    /**
     * Returns the y positional coordinate
     * @return
     */
    public int getyPosition(){
        return this.yPosition;
    }

    public void pieceSelected(){
    }
}
