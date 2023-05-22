package org.vitalvale.Game.Item;

public class Item {
    private int id;
    private String name;
    private EItemTypes itemType;
    private int maxPickup;

    /**
     * Constructs a new Item Object
     * @param id ID of the Item
     * @param name Name of the Item
     * @param itemType Type of the Item ( EItemTypes Enum )
     * @param maxPickup Max amount of pickup for every Player Inventory
     */
    public Item(int id, String name, EItemTypes itemType, int maxPickup)
    {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.maxPickup = maxPickup;
    }
    /**
     * Constructs a new Item Object
     * @param id ID of the Item
     * @param name Name of the Item
     * @param itemType Type of the Item ( EItemTypes Enum )
     */
    public Item(int id, String name, EItemTypes itemType)
    {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.maxPickup = 1000;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EItemTypes getItemType() {
        return itemType;
    }

    public void setItemType(EItemTypes itemType) {
        this.itemType = itemType;
    }

    public int getMaxPickup() {
        return maxPickup;
    }

    public void setMaxPickup(int maxPickup) {
        this.maxPickup = maxPickup;
    }
}
