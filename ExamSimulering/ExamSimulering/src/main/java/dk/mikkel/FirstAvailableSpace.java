package dk.mikkel;

import dk.mikkel.Interfaces.IFindSpaceStategy;

import java.util.ArrayList;

public class FirstAvailableSpace implements IFindSpaceStategy {

    @Override
    public ItemShelf findSpace(ArrayList<ItemShelf> shelves, Item item){
        for(ItemShelf i : shelves){
            if(i.getCapacity() > item.getSize()){
                return i;
            }
        }
        return null;
    }
}
