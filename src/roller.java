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
        ArrayList<Integer> newStatBlock = new ArrayList<>();

        int counter = 0;

        for(int i = 0; i < statBlock.size(); i++){
            if(statBlock.get(i) == 1){
                counter++;
            } else {
                newStatBlock.add(statBlock.get(i));
            }
        }

        while(counter != 0){
            newStatBlock.add(numGen.nextInt(6)+1);
            counter--;
        }


        return newStatBlock;
    }


    //Generates the stat block but it re-rolls the two lowest stats and takes the highest
    public ArrayList generateStatBlockRLow2(){
        ArrayList<Integer> statBlock = generateStatBlock();

        int min1 = Collections.min(statBlock);
        statBlock.remove(Collections.min(statBlock));

        int min2 = Collections.min(statBlock);
        statBlock.remove(Collections.min(statBlock));

        int reroll1 = numGen.nextInt(6) + 1;
        int reroll2 = numGen.nextInt(6) + 1;

        if(min1 > reroll1){
            statBlock.add(min1);
        } else {
            statBlock.add(reroll1);
        }

        if(min2 > reroll2){
            statBlock.add(min2);
        } else {
            statBlock.add(reroll2);
        }

        //statBlock.add(numGen.nextInt(6)+1);
        //statBlock.add(numGen.nextInt(6)+1);


        return statBlock;
    }

    public ArrayList generateBlock20Sub2D6(){
        ArrayList<Integer> statBlock = new ArrayList();
        for(int i = 0; i < 4; i++){

        }

        return statBlock;

    }



}
