package Homework_4;

public class RogueAI extends AI
{
    public int firewallProtection;
    public int alertLevel;
    public final int maxAlert;


    public RogueAI(int firewallProtection, int alertLevel, int maxAlert, Coordinates cannonTarget, Coordinates secretHQ)
    {
        super(cannonTarget,secretHQ);
        this.firewallProtection = firewallProtection;
        this.alertLevel = alertLevel;
        this.maxAlert = maxAlert;
    }
    public RogueAI(int firewallProtection, int maxAlert, Coordinates cannonTarget, Coordinates secretHQ)
    {
        this(firewallProtection,0,maxAlert,cannonTarget,secretHQ);

    }
    public RogueAI(int firewallProtection, Coordinates cannonTarget, Coordinates secretHQ)
    {
        this(firewallProtection,0,10,cannonTarget,secretHQ);
    }
    public void lowerFirewall()
    {
        firewallProtection -=2;
        alertLevel++;
    }
    public int getFirewallProtection()
    {
        return firewallProtection;
    }
    @Override
    public boolean shouldSwapCannonTarget() {
        if(firewallProtection <= 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldSelfDestruct() {
        if(alertLevel >= maxAlert)
        {
            return true;
        }
        return false;
    }
    public String toString()
    {
        return super.toString() + "and it has awareness level" + alertLevel + "and firewall protection" + firewallProtection;
    }
}