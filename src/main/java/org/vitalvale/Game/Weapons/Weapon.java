package org.vitalvale.Game.Weapons;

import org.vitalvale.Game.Item.EItemTypes;
import org.vitalvale.Game.Item.Item;

public class Weapon extends Item {
    private EWeaponTypes weaponType;
    private int currentAmmo;
    private int maxAmmo;

    public Weapon(int id, String name, EItemTypes itemType, EWeaponTypes weaponType, int currentAmmo, int maxAmmo)
    {
        super();
        this.setId(id);
        this.setName(name);
        this.setItemType(itemType);
        this.weaponType = weaponType;
        this.currentAmmo = currentAmmo;
        this.maxAmmo = maxAmmo;
    }

    /**
     * Constructs a new Weapon Object
     * @param id ID of the Item
     * @param name Name of the Item
     * @param itemType Type of the Item ( EItemTypes Enum )
     * @param maxPickup Max amount of pickup for every Player Inventory
     */
    public Weapon(int id, String name, EItemTypes itemType, int maxPickup) {
        super(id, name, itemType, maxPickup);
    }
    /**
     * Constructs a new Weapon Object
     * @param id ID of the Weapon
     * @param name Name of the Weapon
     * @param itemType Type of the Weapon ( EWeaponTypes Enum )
     */
    public Weapon(int id, String name, EItemTypes itemType) {
        super(id, name, itemType);
    }
}
