import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Rook extends ChessPiece {

    public Rook(Image image, int position){
        super(image, position);
    }

    /*
     * Method called when a chess piece is selected
     *
     */
    public void pieceSelected(){
        ChessBoardManager chessBoardManager = ChessBoardManager.getInstance();
        ChessBoard chessBoard = chessBoardManager.getChessBoard();

        System.out.println("xPosition: " + xPosition + " yPosition: " + yPosition);

        for (int i = yPosition - 1; i >= 0; i--){ // checks upward direction for movement
            int position = getPositionFromCoordinates(xPosition, i);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
        }

        for (int j = yPosition + 1; j < 8; j++){ // checks downward direction for movement
            int position = getPositionFromCoordinates(xPosition, j);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
        }

        for (int k = xPosition + 1; k < 8; k++){ // checks downward direction for movement
            int position = getPositionFromCoordinates(k, yPosition);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
        }

        for (int l = xPosition - 1; l < 8; l--){ // checks downward direction for movement
            int position = getPositionFromCoordinates(l, yPosition);
            if (movablePosition(position, chessBoard)){
                if(squareContainsPiece(position, chessBoard)){
                    break;
                }
            } else {
                break;
            }
        }
        colorMovablePositions(chessBoard);
    }
}
