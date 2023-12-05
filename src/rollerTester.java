import java.util.*;
public class rollerTester {
    //Class is specifically used during testing to verify both the roller class and the stat class work as intended

    public static void main(String[] args){
        System.out.println("Testing started");

        roller statRoller = new roller();


        stat testingBlock = new stat(statRoller.generateStatBlockRLow2());

        ArrayList<Integer> stats = testingBlock.exportBlock();

        System.out.println("Total stats of the block (without population): " + testingBlock.totalStat());




        System.out.println("Total stats of the block: " + testingBlock.totalStat());

        for(int i = 0; i < stats.size(); i++){
            System.out.print(stats.get(i) + " ");
            System.out.println();
        }

    }
}
