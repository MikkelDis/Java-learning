package dk.mikkel;

import dk.mikkel.Interfaces.IFindSpaceStategy;

import java.util.ArrayList;

public class MostAvailableSpace implements IFindSpaceStategy {
    @Override
    public ItemShelf findSpace(ArrayList<ItemShelf> shelves, Item item){
        ItemShelf currentShelf = null;
        for(ItemShelf i : shelves){
            //Nedestående udtryk er ret grim. Men den tjekker bare igennem alle shelves for at se hvilken har mest plads
            //Dog finder den også den første som har plads så currentshelf ikke er null.
            if((i.getCapacity() > item.getSize()) && ((currentShelf == null) || (i.getCapacity() > currentShelf.getCapacity()))){
                currentShelf = i;
            }
        }
        return currentShelf;
    }
}
