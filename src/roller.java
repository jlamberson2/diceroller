import java.lang.reflect.Array;
import java.util.*;
public class roller {
    private Random numGen = new Random();

    //Generates the standard stat block as per 4D6 drop the lowest
    public ArrayList generateStatBlock(){
        ArrayList<Integer> statBlock = new ArrayList<>();
        statBlock.add(numGen.nextInt(6)+1);
        statBlock.add(numGen.nextInt(6)+1);
        statBlock.add(numGen.nextInt(6)+1);
        statBlock.add(numGen.nextInt(6)+1);

        return statBlock;
    }

    //Generates the stat block but rerolls the 1s once only
    public ArrayList generateStatBlockR1(){
        ArrayList<Integer> statBlock = generateStatBlock();

        for(int i = 0; i < statBlock.size(); i++){
            if(statBlock.get(i)==1){
                statBlock.remove(i);
                statBlock.add(0, numGen.nextInt(6)+1);
            }
        }

        return statBlock;
    }


    //Generates the stat block but it re-rolls the two lowest stats
    //TO ADD see if we want to replace the stat overall or just take the highest of the rolls
    public ArrayList generateStatBlockRLow2(){
        ArrayList<Integer> statBlock = generateStatBlock();

        statBlock.remove(Collections.min(statBlock));
        statBlock.remove(Collections.min(statBlock));



        statBlock.add(numGen.nextInt(6)+1);
        statBlock.add(numGen.nextInt(6)+1);


        return statBlock;
    }



}
