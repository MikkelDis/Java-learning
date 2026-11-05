package dk.mikkel;

import dk.mikkel.Interfaces.IObserver;

public class ItemRemovedObserver implements IObserver {

    @Override
    public void update(String event){
        if(event.equals("itemRemoved")){
            System.out.println("An item was removed");
        }
    }
}
