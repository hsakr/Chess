import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Bishop extends ImageView implements ChessPiece  {
    public static final Color black = Color.BLACK;
    public static final Color white = Color.WHITE;

    private Image image;
    private Color color;
    private int xPosition, yPosition;

    public Bishop(Image image, Color color, int position){
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
    public int getXPosition(){
        return this.xPosition;
    }

    /**
     * Returns the y positional coordinate
     * @return
     */
    public int getYPosition(){
        return this.yPosition;
    }

    /*
     * Method called when a chess piece is selected
     *
     */
    public void pieceSelected(){
        ChessBoardManager chessBoardManager = ChessBoardManager.getInstance();
        ChessBoard chessBoard = chessBoardManager.getChessBoard();

        System.out.println("xPosition: " + xPosition + " yPosition: " + yPosition);

        int positionX = xPosition + 1;
        int positionY = yPosition - 1;
        while (positionX < 8 && positionY < 8){ // checks top right direction for movement
            int position = getPositionFromCoordinates(positionX, positionY);
            if (movablePosition(position, chessBoard)){
                ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
                chessSquare.getSquare().setFill(Color.YELLOW);
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            positionX++;
            positionY--;
        }

        positionX = xPosition - 1;
        positionY = yPosition - 1;
        while (positionX < 8 && positionY < 8){ // checks top left direction for movement
            int position = getPositionFromCoordinates(positionX, positionY);
            if (movablePosition(position, chessBoard)){
                ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
                chessSquare.getSquare().setFill(Color.YELLOW);
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            positionX--;
            positionY--;
        }

        positionX = xPosition + 1;
        positionY = yPosition + 1;
        while (positionX < 8 && positionY < 8){ // checks bottom right direction for movement
            int position = getPositionFromCoordinates(positionX, positionY);
            if (movablePosition(position, chessBoard)){
                ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
                chessSquare.getSquare().setFill(Color.YELLOW);
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            positionX++;
            positionY++;
        }

        positionX = xPosition - 1;
        positionY = yPosition + 1;
        while (positionX < 8 && positionY < 8){ // checks bottom left direction for movement
            int position = getPositionFromCoordinates(positionX, positionY);
            if (movablePosition(position, chessBoard)){
                ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
                chessSquare.getSquare().setFill(Color.YELLOW);
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            positionX--;
            positionY++;
        }
    }

    /**
     * Method converts x and y coordinates to position in Observablelist tilePane
     * @param xPosition
     * @param yPosition
     * @return
     */
    public int getPositionFromCoordinates(int xPosition, int yPosition){
        if(xPosition >= 8 || yPosition >= 8 || xPosition < 0 || yPosition < 0){
            return Integer.MAX_VALUE;
        }
        return (xPosition) + (yPosition * 8);
    }

    /**
     * Method that checks if the chess piece can move to a square
     * @param position
     * @return
     */
    private boolean movablePosition(int position, ChessBoard chessBoard){
        if (position >= 0 && position < 64){
            ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
            if(checkSquare(chessSquare)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to movablePosition to check whether a chess piece can move to a square that contains another chess piece
     * @param chessSquare
     * @return
     */
    private boolean checkSquare(ChessSquare chessSquare){
        if(chessSquare.getChildren().size() == 2){
            ChessPiece chessPiece = (ChessPiece)chessSquare.getChildren().get(1);
            if(chessPiece.getColor() != color){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * Checks if the square at a position contains a chess piece
     * @param position
     * @param chessBoard
     * @return
     */
    private boolean squareContainsPiece(int position , ChessBoard chessBoard){
        ChessSquare chessSquare = (ChessSquare)chessBoard.getChildren().get(position);
        if(chessSquare.getChildren().size() == 2){
            return true;
        } else {
            return false;
        }
    }
}
