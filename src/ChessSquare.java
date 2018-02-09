import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessSquare extends StackPane {

    public static final int squareLength = 80;
    public static final Color gray = Color.LIGHTGRAY;
    public static final Color white = Color.WHITE;

    private Rectangle square = new Rectangle(squareLength, squareLength);
    private int xPosition, yPosition;
    private int position;

    public ChessSquare(int position){
        this.position = position;
        findPositionCoordinates(position);
        square.setFill(getSquareColor());
        this.getChildren().add(square);
        this.setOnMouseClicked(e -> squareSelected());
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
     * Returns the color of the square at a certain position on the board
     * @return
     */
    private Color getSquareColor(){
        if (xPosition % 2 == 0 && (yPosition == 0 || yPosition % 2 == 0)){
            return white;
        } else if (xPosition % 2 != 0 && yPosition % 2 != 0){
            return white;
        } else {
            return gray;
        }
    }

    public void squareSelected(){
        System.out.println("Square Position: " + position + " xPosition: " + xPosition + " yPosition: " + yPosition);
        if(getChildren().size() == 2){
            ChessPiece chessPiece = (ChessPiece) getChildren().get(1);
            chessPiece.pieceSelected();
        }
    }

    public Rectangle getSquare(){
        return this.square;
    }
}
