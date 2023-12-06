import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class rollerController {


    //Standard assignment for all the FXML objects
    @FXML
    private Button exportToFile;

    @FXML
    private Button reroll1s;

    @FXML
    private Button rerollLow2;

    @FXML
    private Button standardArray;

    @FXML
    private Button standardRoll;

    @FXML
    private ChoiceBox<?> statAssign1;

    @FXML
    private ChoiceBox<?> statAssign2;

    @FXML
    private ChoiceBox<?> statAssign3;

    @FXML
    private ChoiceBox<?> statAssign4;

    @FXML
    private ChoiceBox<?> statAssign5;

    @FXML
    private ChoiceBox<?> statAssign6;

    @FXML
    private TextArea statText1;

    @FXML
    private TextArea statText2;

    @FXML
    private TextArea statText3;

    @FXML
    private TextArea statText4;

    @FXML
    private TextArea statText5;

    @FXML
    private TextArea statText6;


    //Action for the standard array button
    @FXML
    void defaultGeneration(ActionEvent event) {

    }

    //action for the reroll lowest 2 button
    @FXML
    void rollRerollLow2(ActionEvent event) {

    }

    //action for the standard roll (4D6) button
    @FXML
    void rollStandardStats(ActionEvent event) {

    }

    //action for the reroll 1s button
    @FXML
    void rollStatsRe1s(ActionEvent event) {

    }

    //action for the export stats to file button
    @FXML
    void saveToFile(ActionEvent event) {

    }

}
