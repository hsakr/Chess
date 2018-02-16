import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Bishop extends ChessPiece {

    public Bishop(Image image){
        super(image);
    }

    /*
     * Method called when a chess piece is selected
     *
     */
    public void pieceSelected(int pieceSelectedPosition, int xPosition, int yPosition){
        this.pieceSelectedPosition = pieceSelectedPosition;
        ChessBoardManager chessBoardManager = ChessBoardManager.getInstance();
        ChessBoard chessBoard = chessBoardManager.getChessBoard();

        System.out.println("xPosition: " + xPosition + " yPosition: " + yPosition);

        checkContinuousDirection(xPosition, yPosition, 1, -1, chessBoard); // checks top right direction for movement
        checkContinuousDirection(xPosition, yPosition, -1, -1, chessBoard); // checks top left direction for movement
        checkContinuousDirection(xPosition, yPosition, +1, +1, chessBoard); // checks bottom right direction for movement
        checkContinuousDirection(xPosition, yPosition, -1, +1, chessBoard); // checks bottom left direction for movement
        colorMovablePositions(chessBoard);
    }

    /*
     * Checks continuous direction for movable positions
     */
    private void checkContinuousDirection(int xPosition, int yPosition, int moveX, int moveY, ChessBoard chessBoard){
        xPosition = xPosition + moveX;
        yPosition = yPosition + moveY;
        while (xPosition < 8 && yPosition < 8){ // checks bottom left direction for movement
            int position = getPositionFromCoordinates(xPosition, yPosition);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
            xPosition += moveX;
            yPosition += moveY;
        }
    }
}
