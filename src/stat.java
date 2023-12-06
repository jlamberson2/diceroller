import java.util.*;
public class stat {

    private ArrayList<Integer> statBlock;

    public stat(){
        statBlock = new ArrayList<>();
    }

    //Allows the importation of a stat block
    public stat(ArrayList<Integer> manualImport){
        statBlock = manualImport;
    }

    //Allows the manual assignment of rolls
    public stat(int a, int b, int c, int d){
        statBlock = new ArrayList<Integer>();
        statBlock.add(a);
        statBlock.add(b);
        statBlock.add(c);
        statBlock.add(d);
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

    //toString method that outputs the stat
    public String toString(){
        Collections.sort(statBlock, Collections.reverseOrder());
        String statString = "Rolls: " +  statBlock.toString() + "\nTotal: " + totalStat();
        return statString;
    }
}
