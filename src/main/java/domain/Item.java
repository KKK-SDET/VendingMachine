package domain;

public class Item {
    private String name;
    private long price;

    public Item(String name, int price)
    {
        this.name = name; this.price = price;
    }
    public String getName() {
        return name;
    }
    public long getPrice() {
        return price;
    }

    public String toString()
    {
        return name;
    }
}
