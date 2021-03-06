package Homework_3;

public enum VendingItem
{
    LAYS (1.50),
    DORITOS (1.50),
    COKE (2.50),
    RAMBLIN_RECK_TOY (180.75),
    RUBIKS_CUBE (30.00),
    RAT_CAP (15.00),
    FASET_LANYARD (10.00),
    GRAPHING_CALCULATOR (120.00),
    UGA_DIPLOMA (0.10),
    PIE (3.14),
    CLICKER (55.55),
    CHEETOS (1.25),
    SPRITE (2.50),
    RED_BULL (4.75),
    RAMEN (3.15),
    COLD_PIZZA (0.99);

    private final double price;

    VendingItem(double price)
    {
        this.price = price;
    }
    public double getPrice()
    {
        return price;
    }
    public String toString()
    {
        return this.name() + " " + getPrice();
    }


}