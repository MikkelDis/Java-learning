package dk.mikkel;

import dk.mikkel.Interfaces.IFindSpaceStategy;

import java.util.ArrayList;

public class MostAvailableSpace implements IFindSpaceStategy {
    @Override
    public ItemShelf findSpace(ArrayList<ItemShelf> shelves, Item item){
        ItemShelf currentShelf = null;
        for(ItemShelf i : shelves){
            if((i.getCapacity() > item.getSize()) && ((currentShelf == null) || (i.getCapacity() > currentShelf.getCapacity()))){
                currentShelf = i;
            }
        }
        return currentShelf;
    }
}
