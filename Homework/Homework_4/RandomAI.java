package Homework_4;

import java.util.Random;

public class RandomAI extends AI
{
    public RandomAI(Coordinates cannonTarget, Coordinates secretHQ)
    {
        super(cannonTarget, secretHQ);
    }
    @Override
    public boolean shouldSwapCannonTarget()
    {
        Random rand = new Random();
        if(rand.nextInt(2) == 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldSelfDestruct() {
        Random rand = new Random();
        if(rand.nextInt(2) == 0)
        {
            return true;
        }
        return false;
    }
}