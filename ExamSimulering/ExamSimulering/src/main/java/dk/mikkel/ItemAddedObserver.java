package dk.mikkel;

import dk.mikkel.Interfaces.IObserver;

public class ItemAddedObserver implements IObserver {

    @Override
    public void update(String event){
        if(event.equals("itemAdded")){
            System.out.println("An item was added");
        }
    }
}
