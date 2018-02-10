import javafx.application.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;

import java.util.Vector;

public class Main extends Application implements Colors{

    private BorderPane chessProgram = new BorderPane();
    private ChessBoardManager chessBoardManager = ChessBoardManager.getInstance();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private static boolean whitePlayerTurn = true;
    private static Vector<Round> rounds = new Vector<Round>();

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        chessProgram.setCenter(chessBoardManager.getChessBoard());
        Scene scene = new Scene(chessProgram);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        startGame();
    }

    public void startGame(){
        player1.setPlayerColor(black);
        player2.setPlayerColor(white);
        player1.setPlayerName("Player1");
        player2.setPlayerName("Player2");
        Round round = new Round();
        rounds.add(round);
    }


    public static void nextPlayerTurn(){
        if (whitePlayerTurn) {
            whitePlayerTurn = false;
        } else {
            whitePlayerTurn = true;
        }
    }

    public static int getRoundNumber(){
        return rounds.size();
    }

    public static boolean getWhitePlayerTurn(){
        return whitePlayerTurn;
    }

    public static boolean checkPlayerTurn(ChessPiece chessPiece){
        Color color = chessPiece.getColor();
        if (color == white && whitePlayerTurn){
            return true;
        } else if (color == black && !whitePlayerTurn){
            return true;
        } else {
            return false;
        }

    }
}
