import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;

import java.net.URL;
import java.util.*;
import java.util.concurrent.*;

public class rollerController implements Initializable {

    roller statRoller = new roller();
    stat statBlock1;
    stat statBlock2;
    stat statBlock3;
    stat statBlock4;
    stat statBlock5;
    stat statBlock6;

    private String[] statChoices = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma", "Unselected"};
    private String[] classChoices = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rouge", "Sorcerer", "Warlock", "Wizard", "Artificer", "Unassigned"};
    private String[] rollChoices = {"Standard Array", "Roll 4D6", "Reroll 1s", "Reroll Lowest 2", "Guarantee One 18"};


    //Standard assignment for all the FXML objects
    @FXML
    private Label currentRollMethod;

    @FXML
    private Button exportToFile;

    /*
    //Depreciated code that is no longer used, replaced with the rollMethodSelector ChoiceBox and the statRoll button
    @FXML
    private Button reroll1s;

    @FXML
    private Button rerollLow2;

    @FXML
    private Button standardArray;

    @FXML
    private Button standardRoll;

    @FXML
    private Button statUpdate;*/

    @FXML
    private Button statRoll;

    @FXML
    private ChoiceBox<String> classSelection;

    @FXML
    private ChoiceBox<String> statAssign1;

    @FXML
    private ChoiceBox<String> statAssign2;

    @FXML
    private ChoiceBox<String> statAssign3;

    @FXML
    private ChoiceBox<String> statAssign4;

    @FXML
    private ChoiceBox<String> statAssign5;

    @FXML
    private ChoiceBox<String> statAssign6;

    @FXML
    private ChoiceBox<String> rollMethodSelector;

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


    @FXML
    private Pane primaryStage;


    //Action for the standard array generation
    private void defaultGeneration() {
        currentRollMethod.setText("Standard Array");
        defaultArray();
        refreshStatText();
    }

    //action for the reroll lowest 2 selection
    private void rollRerollLow2() {
        currentRollMethod.setText("Reroll Lowest 2");

        statBlock1 = new stat(statRoller.generateStatBlockRLow2());
        statBlock2 = new stat(statRoller.generateStatBlockRLow2());
        statBlock3 = new stat(statRoller.generateStatBlockRLow2());
        statBlock4 = new stat(statRoller.generateStatBlockRLow2());
        statBlock5 = new stat(statRoller.generateStatBlockRLow2());
        statBlock6 = new stat(statRoller.generateStatBlockRLow2());

        refreshStatText();

    }

    //action for the standard roll (4D6) selection
    private void rollStandardStats() {
        currentRollMethod.setText("Standard 4D6 Roll");

        statBlock1 = new stat(statRoller.generateStatBlock());
        statBlock2 = new stat(statRoller.generateStatBlock());
        statBlock3 = new stat(statRoller.generateStatBlock());
        statBlock4 = new stat(statRoller.generateStatBlock());
        statBlock5 = new stat(statRoller.generateStatBlock());
        statBlock6 = new stat(statRoller.generateStatBlock());

        refreshStatText();

    }

    //action for the reroll 1s selection
    private void rollStatsRe1s() {
        currentRollMethod.setText("Reroll 1s");

        statBlock1 = new stat(statRoller.generateStatBlockR1());
        statBlock2 = new stat(statRoller.generateStatBlockR1());
        statBlock3 = new stat(statRoller.generateStatBlockR1());
        statBlock4 = new stat(statRoller.generateStatBlockR1());
        statBlock5 = new stat(statRoller.generateStatBlockR1());
        statBlock6 = new stat(statRoller.generateStatBlockR1());

        refreshStatText();
    }

    //method for a future button that guarantees at least 1, 18 stat block
    void guarantee18(){
        statBlock1 = new stat(6,6,6,1);
        statBlock2 = new stat(statRoller.generateStatBlock());
        statBlock3 = new stat(statRoller.generateStatBlock());
        statBlock4 = new stat(statRoller.generateStatBlock());
        statBlock5 = new stat(statRoller.generateStatBlock());
        statBlock6 = new stat(statRoller.generateStatBlock());

        refreshStatText();
    }

    //action for the export stats to file button
    @FXML
    void saveToFile(ActionEvent event) throws IOException, InterruptedException {
        /*String temp = currentRollMethod.getText();

        //currentRollMethod.setText("Saving to file");*/

        saveToFile();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        statAssign1.getItems().addAll(statChoices);
        statAssign2.getItems().addAll(statChoices);
        statAssign3.getItems().addAll(statChoices);
        statAssign4.getItems().addAll(statChoices);
        statAssign5.getItems().addAll(statChoices);
        statAssign6.getItems().addAll(statChoices);

        rollMethodSelector.getItems().addAll(rollChoices);
        rollMethodSelector.setValue("Standard Array");

        classSelection.getItems().addAll(classChoices);
        classSelection.setValue("Unassigned");

        statText1.setEditable(false);
        statText2.setEditable(false);
        statText3.setEditable(false);
        statText4.setEditable(false);
        statText5.setEditable(false);
        statText6.setEditable(false);



        defaultArray();

        rearrange();

        refreshStatText();


    }

    //used to set the stat blocks to the standard array for stats
    private void defaultArray(){
        statBlock1 = new stat(5, 5, 5, 1);
        statBlock2 = new stat(5, 5, 4, 1);
        statBlock3 = new stat(5, 5, 3, 1);
        statBlock4 = new stat(5, 5, 2, 1);
        statBlock5 = new stat(5, 3, 2, 1);
        statBlock6 = new stat(5, 2, 1, 1);
    }


    //Refreshes the text boxes to update to display the new stats that were rolled
    private void refreshStatText(){
        statText1.setText(statBlock1.toString());
        statText2.setText(statBlock2.toString());
        statText3.setText(statBlock3.toString());
        statText4.setText(statBlock4.toString());
        statText5.setText(statBlock5.toString());
        statText6.setText(statBlock6.toString());
    }

    private void saveToFile() throws IOException, InterruptedException {//TODO: make it so each save is a new file
        try {
            File statsFile = new File("Stats Generated.txt");
            if(statsFile.createNewFile()){
                System.out.println("File created: " + statsFile.getName());
            } else System.out.println("File already exists");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(
                statAssign1.getValue().equals("Unselected") ||
                statAssign2.getValue().equals("Unselected") ||
                statAssign3.getValue().equals("Unselected") ||
                statAssign4.getValue().equals("Unselected") ||
                statAssign5.getValue().equals("Unselected") ||
                statAssign6.getValue().equals("Unselected") ||

                //block checks for same values in selector 1 as the rest of the selections
                statAssign1.getValue().equals(statAssign2.getValue()) ||
                statAssign1.getValue().equals(statAssign3.getValue()) ||
                statAssign1.getValue().equals(statAssign4.getValue()) ||
                statAssign1.getValue().equals(statAssign5.getValue()) ||
                statAssign1.getValue().equals(statAssign6.getValue()) ||

                //block checks for the same value in selector 2 as the rest
                statAssign2.getValue().equals(statAssign3.getValue()) ||
                statAssign2.getValue().equals(statAssign4.getValue()) ||
                statAssign2.getValue().equals(statAssign5.getValue()) ||
                statAssign2.getValue().equals(statAssign6.getValue()) ||

                        //block checks for the same values in selector 3 as the rest
                        statAssign3.getValue().equals(statAssign4.getValue()) ||
                        statAssign3.getValue().equals(statAssign5.getValue()) ||
                        statAssign3.getValue().equals(statAssign6.getValue()) ||

                            //block checks for the same values in selector 4 as the rest
                            statAssign4.getValue().equals(statAssign5.getValue()) ||
                            statAssign4.getValue().equals(statAssign6.getValue()) ||

                                statAssign5.getValue().equals(statAssign6.getValue()))
        {

            //Used to pop up an alert window to the user explaining why the save was not made
            Stage stage = (Stage) primaryStage.getScene().getWindow();
            AlertType type = AlertType.WARNING;
            Alert alert = new Alert(type, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);

            alert.getDialogPane().setHeaderText("Error saving: Only one value can be assigned to one stat or one stat is unassigned");

            alert.showAndWait();
        }else {



        String textOutput = "Start New Stat Block: \n" + statBlock1.toString() + "\nAssigned to: " + statAssign1.getValue() + "\n\n" +
                statBlock2.toString() + "\nAssigned to: " + statAssign2.getValue() + "\n\n" +
                statBlock3.toString() + "\nAssigned to: " + statAssign3.getValue() + "\n\n" +
                statBlock4.toString() + "\nAssigned to: " + statAssign4.getValue() + "\n\n" +
                statBlock5.toString() + "\nAssigned to: " + statAssign5.getValue() + "\n\n" +
                statBlock6.toString() + "\nAssigned to: " + statAssign6.getValue() + "\n\n\n";

        FileWriter outputWriter = new FileWriter("Stats Generated.txt", true);
        outputWriter.write(textOutput);
        outputWriter.close();

            Stage stage = (Stage) primaryStage.getScene().getWindow();
            AlertType type = AlertType.INFORMATION;
            Alert alert = new Alert(type, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);

            alert.getDialogPane().setHeaderText("Save Complete");

            alert.showAndWait();
        }
    }

    //action for the "Update Stats" button
    @FXML
    void statSelectionUpdate(ActionEvent event) {
        ArrayList<Integer> statTotals = new ArrayList<>();
        statTotals.add(statBlock1.totalStat());
        statTotals.add(statBlock2.totalStat());
        statTotals.add(statBlock3.totalStat());
        statTotals.add(statBlock4.totalStat());
        statTotals.add(statBlock5.totalStat());
        statTotals.add(statBlock6.totalStat());

        int max = Collections.max(statTotals); int maxLoc = statTotals.indexOf(max);
        int maxMin; int maxMinLoc;

        if(maxLoc == 0){
            maxMin = statTotals.get(1);
            maxMinLoc = 1;
        } else {
            maxMin = statTotals.get(0);
            maxMinLoc = 0;
        }

        for(int i = 0; i < statTotals.size(); i++){

            if(i != maxLoc && maxMin < statTotals.get(i)){
                maxMin = statTotals.get(i);
                maxMinLoc = i;
            }

        }

        switch (classSelection.getValue()){
            case "Barbarian":
                reassign(maxLoc, "Strength");
                reassign(maxMinLoc, "Constitution");
                break;
            case "Bard":
                reassign(maxLoc, "Charisma");
                reassign(maxMinLoc, "Dexterity");
                break;
            case "Cleric":
                reassign(maxLoc, "Wisdom");
                reassign(maxMinLoc, "Strength");
                break;
            case "Druid":
                reassign(maxLoc, "Wisdom");
                reassign(maxMinLoc, "Constitution");
                break;
            case "Fighter":
                reassign(maxLoc, "Dexterity");
                reassign(maxMinLoc, "Constitution");
                break;
            case "Monk":
            case "Ranger":
                reassign(maxLoc, "Dexterity");
                reassign(maxMinLoc, "Wisdom");
                break;
            case "Paladin":
                reassign(maxLoc, "Strength");
                reassign(maxMinLoc, "Charisma");
                break;
            case "Rogue":
                reassign(maxLoc, "Dexterity");
                reassign(maxMinLoc, "Charisma");
                break;
            case "Sorcerer":
            case "Warlock":
                reassign(maxLoc, "Charisma");
                reassign(maxMinLoc, "Constitution");
                break;
            case "Wizard":
                reassign(maxLoc, "Intelligence");
                reassign(maxMinLoc, "Dexterity");
                break;
            case "Artificer":
                reassign(maxLoc, "Intelligence");
                reassign(maxMinLoc, "Constitution");
                break;
            case "Unassigned":
                unassignedAlert();
                break;
        }

        rearrange(maxLoc, maxMinLoc);

    }

    private void unassignedAlert(){
        Stage stage = (Stage) primaryStage.getScene().getWindow();
        AlertType type = AlertType.CONFIRMATION;
        Alert alert = new Alert(type, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setHeaderText("Warning, class not selected. Reset to default?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK){
            rearrange();
        }
    }

    private void reassign(int location, String stat){
        switch(location){
            case 0:
                statAssign1.setValue(stat);
                break;
            case 1:
                statAssign2.setValue(stat);
                break;
            case 2:
                statAssign3.setValue(stat);
                break;
            case 3:
                statAssign4.setValue(stat);
                break;
            case 4:
                statAssign5.setValue(stat);
                break;
            case 5:
                statAssign6.setValue(stat);
                break;
        }
    }

    //Used to reset the stat selectors that were not used by recommendations to Unassigned
    private void rearrange(int assign1, int assign2){
        if(assign1 != 0 && assign2 != 0){
            statAssign1.setValue("Unassigned");
        } else if(assign1 != 1 && assign2 != 1){
            statAssign2.setValue("Unassigned");
        } else if(assign1 != 2 && assign2 != 2){
            statAssign3.setValue("Unassigned");
        } else if(assign1 != 3 && assign2 != 3){
            statAssign4.setValue("Unassigned");
        } else if(assign1 != 4 && assign2 != 4){
            statAssign5.setValue("Unassigned");
        } else if(assign1 != 5 && assign2 != 5){
            statAssign6.setValue("Unassigned");
        }
    }

    private void rearrange(){
        statAssign1.setValue("Unselected");
        statAssign2.setValue("Unselected");
        statAssign3.setValue("Unselected");
        statAssign4.setValue("Unselected");
        statAssign5.setValue("Unselected");
        statAssign6.setValue("Unselected");
    }

    //Used alongside the choice a user selects for rolling to then generate the stats with a switch case
    @FXML
    void rollSelection(ActionEvent event){
        String selection = rollMethodSelector.getValue();

        switch(selection){
            case "Roll 4D6":
                rollStandardStats();
                break;
            case "Reroll 1s":
                rollStatsRe1s();
                break;
            case "Reroll Lowest 2":
                rollRerollLow2();
                break;
            case "Guarantee One 18":
                guarantee18();
                break;
            default:
                defaultArray();
                break;
        }
        refreshStatText();
    }
    //private String[] rollChoices = {"Standard Array", "Roll 4D6", "Reroll 1s", "Reroll Lowest 2"};

}
