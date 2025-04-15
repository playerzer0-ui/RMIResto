package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Resto extends UnicastRemoteObject implements IMenu {
    public Resto() throws RemoteException {
    }

    @Override
    public String getPizza(){
        System.out.println("pizza is served!");
        return "pizza is here!";
    }

    @Override
    public String getTaco() {
        System.out.println("taco is served");
        return "taco is here!";
    }

    @Override
    public String getWater() {
        System.out.println("serve your boring water......");
        return "water is here!";
    }
}
