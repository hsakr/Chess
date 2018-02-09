import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;

public class Main extends Application {

    private BorderPane chessProgram = new BorderPane();
    private ChessBoardManager chessBoardManager = ChessBoardManager.getInstance();

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

        while (true) { // current player can play in the paranthesis
            break;
        }

    }
}
