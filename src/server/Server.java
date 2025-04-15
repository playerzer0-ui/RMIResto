package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Resto resto = new Resto();

            int portNum = 12345;
            // Start the registry
            startRegistry(portNum);

            //bind the URL to object
            Naming.rebind("rmi://localhost:12345/resto", resto);

        } catch (RemoteException ex) {
            System.out.println("Error occurred when making resto object: " + ex.getMessage());
        }
        catch(MalformedURLException ex)
        {
            System.out.println("Error occurred when storing resto at specified URL: " + ex.getMessage());
        }
    }

    // This method starts an RMI registry on the local host, if it
    // does not already exist at the specified port number. (basically the magic word to start registry)
    private static void startRegistry(int RMIPortNum) throws RemoteException
    {
        try {
            // Try to get the registry at a specific port number
            // If there is no registry started on that port, an exception will be thrown
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);

            registry.list();
        } catch (RemoteException ex) {
            // No valid registry at that port.
            System.out.println("RMI registry cannot be located at port " + RMIPortNum);

            // Create a registry on the given port number
            LocateRegistry.createRegistry(RMIPortNum);
            System.out.println("RMI registry created at port " + RMIPortNum);
        }
    } // end startRegistry
}
