import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Rook extends ChessPiece {

    public Rook(Image image){
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

        checkContinuousDirection(xPosition, yPosition, 0, -1, chessBoard); // checks upward direction for movement
        checkContinuousDirection(xPosition, yPosition, 0, +1, chessBoard); // checks downward direction for movement
        checkContinuousDirection(xPosition, yPosition, +1, 0, chessBoard); // checks right direction for movement
        checkContinuousDirection(xPosition, yPosition, -1, 0, chessBoard); // checks left direction for movement
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
