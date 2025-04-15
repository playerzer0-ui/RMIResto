package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMenu extends Remote {

    public String getPizza() throws RemoteException;

    public String getTaco() throws RemoteException;

    public String getWater() throws RemoteException;

}
