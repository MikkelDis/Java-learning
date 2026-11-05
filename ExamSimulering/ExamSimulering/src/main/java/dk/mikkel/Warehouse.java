package dk.mikkel;

import dk.mikkel.Interfaces.IFindSpaceStategy;

import java.util.ArrayList;
import java.util.Collections;

public class Warehouse {
    private ArrayList<ItemShelf> itemShelves = new ArrayList<>();

    public Warehouse(ItemShelf... itemShelves){
        for(ItemShelf i : itemShelves){
            i.setWarehouse(this);
            this.itemShelves.add(i);
        }
    }

    public void addShelf(ItemShelf shelf){
        this.itemShelves.add(shelf);
    }

    public void printShelf(String shelfName){
        for(ItemShelf i : this.itemShelves){
            if(i.getName().equals(shelfName)){
                System.out.println(i.toString());
            }
        }
    }

    public boolean addItemToShelf(String shelfName, Item item){
        for(ItemShelf i : this.itemShelves){
            if(i.getName().equals(shelfName)){
                return i.addItem(item);
            }
        }
        return false;
    }

    public boolean removeItemFromShelf(String shelfName, String itemName){
        for (ItemShelf i : this.itemShelves){
            if(i.getName().equals(shelfName)){
                return i.removeItem(itemName);
            }
        }
        return false;
    }

    public ItemShelf findSpace(IFindSpaceStategy stategy, Item item){
        return stategy.findSpace(this.itemShelves, item);
    }
}
