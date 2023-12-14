import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.*;

import java.net.URL;
import java.util.ResourceBundle;

public class rollerController implements Initializable {

    roller statRoller = new roller();
    stat statBlock1;
    stat statBlock2;
    stat statBlock3;
    stat statBlock4;
    stat statBlock5;
    stat statBlock6;

    private String[] statChoices = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma", "Unselected"};
    private String[] classChoices = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rouge", "Sorcerer", "Warlock", "Wizard", "Artificer"};

    //Standard assignment for all the FXML objects
    @FXML
    private Label currentRollMethod;

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
    private Button statUpdate;

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
        currentRollMethod.setText("Standard Array");
        defaultArray();
        refreshStatText();
    }

    //action for the reroll lowest 2 button
    @FXML
    void rollRerollLow2(ActionEvent event) {
        currentRollMethod.setText("Reroll Lowest 2");

        statBlock1 = new stat(statRoller.generateStatBlockRLow2());
        statBlock2 = new stat(statRoller.generateStatBlockRLow2());
        statBlock3 = new stat(statRoller.generateStatBlockRLow2());
        statBlock4 = new stat(statRoller.generateStatBlockRLow2());
        statBlock5 = new stat(statRoller.generateStatBlockRLow2());
        statBlock6 = new stat(statRoller.generateStatBlockRLow2());

        refreshStatText();

    }

    //action for the standard roll (4D6) button
    @FXML
    void rollStandardStats(ActionEvent event) {
        currentRollMethod.setText("Standard 4D6 Roll");

        statBlock1 = new stat(statRoller.generateStatBlock());
        statBlock2 = new stat(statRoller.generateStatBlock());
        statBlock3 = new stat(statRoller.generateStatBlock());
        statBlock4 = new stat(statRoller.generateStatBlock());
        statBlock5 = new stat(statRoller.generateStatBlock());
        statBlock6 = new stat(statRoller.generateStatBlock());

        refreshStatText();

    }

    //action for the reroll 1s button
    @FXML
    void rollStatsRe1s(ActionEvent event) {
        currentRollMethod.setText("Reroll 1s");

        statBlock1 = new stat(statRoller.generateStatBlockR1());
        statBlock2 = new stat(statRoller.generateStatBlockR1());
        statBlock3 = new stat(statRoller.generateStatBlockR1());
        statBlock4 = new stat(statRoller.generateStatBlockR1());
        statBlock5 = new stat(statRoller.generateStatBlockR1());
        statBlock6 = new stat(statRoller.generateStatBlockR1());

        refreshStatText();
    }

    //action for the export stats to file button
    @FXML
    void saveToFile(ActionEvent event) throws IOException {
        //String temp = currentRollMethod.getText();

        currentRollMethod.setText("Saving to file");

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

        statText1.setEditable(false);
        statText2.setEditable(false);
        statText3.setEditable(false);
        statText4.setEditable(false);
        statText5.setEditable(false);
        statText6.setEditable(false);

        currentRollMethod.setWrapText(true);

        defaultArray();

        statAssign1.setValue("Unselected");
        statAssign2.setValue("Unselected");
        statAssign3.setValue("Unselected");
        statAssign4.setValue("Unselected");
        statAssign5.setValue("Unselected");
        statAssign6.setValue("Unselected");

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

    private void saveToFile() throws IOException {
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
            currentRollMethod.setText("Error saving: Only one value can be assigned to one stat/one stat is unassigned");


        }else {



        String textOutput = "Start New Stat Block: \n" + statBlock1.toString() + "\nAssigned to: " + statAssign1.getValue() + "\n\n" +
                statBlock2.toString() + "\nAssigned to: " + statAssign2.getValue() + "\n\n" +
                statBlock3.toString() + "\nAssigned to: " + statAssign3.getValue() + "\n\n" +
                statBlock4.toString() + "\nAssigned to: " + statAssign4.getValue() + "\n\n" +
                statBlock5.toString() + "\nAssigned to: " + statAssign5.getValue() + "\n\n" +
                statBlock6.toString() + "\nAssigned to: " + statAssign6.getValue() + "\n\n\n";

        FileWriter outputWriter = new FileWriter("Stats Generated.txt", true);
        outputWriter.write(textOutput);
        outputWriter.close();}
    }

    //action for the "Update Stats" button
    @FXML
    void statSelectionUpdate(ActionEvent event) {

    }
}
