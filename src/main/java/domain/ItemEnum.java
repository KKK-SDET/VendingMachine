package domain;

public enum ItemEnum {

    COKE(25),
    PEPSI(35),
    SODA(45);

    private int value;

    // getter method
    public int getValue()
    {
        return this.value;
    }

    // enum constructor - cannot be public or protected
    private ItemEnum(int value)
    {
        this.value = value;
    }
}
