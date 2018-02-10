import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Vector;

public class ChessSquare extends StackPane implements Colors{

    public static final int squareLength = 80;

    private Rectangle square = new Rectangle(squareLength, squareLength);
    private int xPosition, yPosition;
    private int position;

    public ChessSquare(int position){
        this.position = position;
        findPositionCoordinates(position);
        setSquareColor();
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
    public void setSquareColor(){
        if (xPosition % 2 == 0 && (yPosition == 0 || yPosition % 2 == 0)){
            square.setFill(white);
        } else if (xPosition % 2 != 0 && yPosition % 2 != 0){
            square.setFill(white);
        } else {
            square.setFill(gray);
        }
    }

    public void squareSelected(){
        System.out.println("Square Position: " + position + " xPosition: " + xPosition + " yPosition: " + yPosition);
        if(ChessPiece.movablePositions.contains(position)){
            ChessPiece.movablePositions.clear();
            ChessBoard chessBoard = ChessBoardManager.getInstance().getChessBoard();
            chessBoard.colorSquares();
            if (chessBoard.getBoard()[position].getChildren().size() == 2) {
                chessBoard.getBoard()[position].getChildren().remove(1);
            }
            chessBoard.getBoard()[position].getChildren().add(
                    chessBoard.getBoard()[ChessPiece.pieceSelectedPosition].getChildren().get(1));
            Main.nextPlayerTurn();
        } else if(getChildren().size() == 2 && Main.checkPlayerTurn((ChessPiece) getChildren().get(1))){
            ChessPiece.movablePositions.clear();
            ChessBoard chessBoard = ChessBoardManager.getInstance().getChessBoard();
            chessBoard.colorSquares();
            ChessPiece chessPiece = (ChessPiece) getChildren().get(1);
            chessPiece.pieceSelected(position, xPosition, yPosition);
        }
    }

    public Rectangle getSquare(){
        return this.square;
    }
}
