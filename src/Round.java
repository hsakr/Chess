import javafx.scene.paint.Color;

public class Round implements Colors{

    private ChessPiece chessPieceMovedType;
    private Color playerTurnColor;
    private int positionBeforeMoving;
    private int positionAfterMoving;
    private int roundNumber;

    public Round(){

    }

    public Color getPlayerTurnColor(){
        return this.playerTurnColor;
    }

    public int getPositionAfterMoving() {
        return positionAfterMoving;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getPositionBeforeMoving() {
        return positionBeforeMoving;
    }

    public ChessPiece getChessPieceMovedType() {
        return chessPieceMovedType;
    }
}
