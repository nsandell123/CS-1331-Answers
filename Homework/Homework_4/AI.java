package Homework_4;

public abstract class AI
{
    boolean destructed;
    Coordinates cannonTarget;
    public Coordinates secretHQ;

    public AI(Coordinates cannonTarget, Coordinates secretHQ)
    {
        this.cannonTarget = cannonTarget;
        this.secretHQ = secretHQ;
        destructed = false;
    }
    public Coordinates getSecretHQ()
    {
        return secretHQ;
    }
    public boolean swapCannonTarget(Coordinates newCoords)
    {
        if(!(destructed) && newCoords != cannonTarget)
        {
            if(shouldSwapCannonTarget())
            {
                cannonTarget = newCoords;
                return true;
            }
            else
            {
                selfDestruct();
                return false;
            }
        }
        return false;
    }
    public abstract boolean shouldSwapCannonTarget();
    public void selfDestruct()
    {
        destructed = true;
        System.out.println(destructed);
    }
    public abstract boolean shouldSelfDestruct();
    public String toString()
    {
        return "Dr. Chiptole's cannon is currently pointed at " + cannonTarget.toString();
    }

}