package Homework_4;

public class DrCS
{
    AI ai;
    String secretIdentity;
    int jlaid;
    boolean safe;
    public DrCS(AI ai, String secretIdentity, int jlaid)
    {
        this.ai = ai;
        this.secretIdentity = secretIdentity;
        this.jlaid = jlaid;
        safe = false;
    }
    public AI getAI()
    {
        return this.ai;
    }
    public void saveTheDay()
    {
        if(this.ai instanceof RogueAI)
        {
            while(((RogueAI) this.ai).getFirewallProtection() > 0)
            {
                ((RogueAI) this.ai).lowerFirewall();
            }
            safe = this.ai.swapCannonTarget(this.ai.getSecretHQ());

        }
        else
        {
            safe = ((RandomAI) (this.ai)).swapCannonTarget(((RandomAI)(this.ai)).getSecretHQ());
        }

    }
    public String getStatus()
    {
        if(safe)
        {
            return "You are safe";
        }
        else if(!safe && this.ai.destructed)
        {
            return "Damn bro you really messed up dawg lmao";
        }
        return "Keep fighting!";

    }
    public String toString()
    {
        return secretIdentity + jlaid;
    }


}