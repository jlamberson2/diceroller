import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class main extends Application {
    //Class is specifically used during testing to verify both the roller class and the stat class work as intended

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Diceroller Ui.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Endangered Dungeons Stat Generator v1.3");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
