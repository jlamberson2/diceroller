import java.util.*;
public class stat {

    ArrayList<Integer> statBlock;

    public stat(){
        statBlock = new ArrayList<>();
    }

    //Allows the importation of a stat block
    public stat(ArrayList<Integer> manualImport){
        statBlock = manualImport;
    }

    //adds a roll to the block
    public void addToBlock(int stat){
        statBlock.add(stat);
    }


    //removes a specific roll from the block
    public void removeFromStat(int stat){
        statBlock.remove(stat);
    }

    //Returns the generating stat from the block by excluding the lowest roll as per 4d6 drop the lowest generation
    public int totalStat(){
        if(statBlock.size() == 0){
            return -1;
        }

        int returnStat = 0;
        int smallestRoll = Collections.min(statBlock);
        boolean excludeStat = true;

        for(int i = 0; i < statBlock.size(); i++){
            if(statBlock.get(i) == smallestRoll && excludeStat){
                excludeStat = false;
            } else {
                returnStat += statBlock.get(i);
            }
        }

        return returnStat;
    }

    //Exports the total array of the stat block
    public ArrayList exportBlock(){
        return statBlock;
    }
}
