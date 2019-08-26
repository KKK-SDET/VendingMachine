package domain;

public enum CoinEnum
{
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    private int value;

    // getter method
    public int getValue()
    {
        return value;
    }

    // enum constructor - cannot be public or protected
    private CoinEnum(int value)
    {
        this.value = value;
    }
}


