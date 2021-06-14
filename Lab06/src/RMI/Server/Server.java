package RMI.Server;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try {
            SquaresRootsEngine squaresRootsEngine = new SquaresRootsEngine();

            Remote squaresRootsStub = UnicastRemoteObject.exportObject(squaresRootsEngine, 1234);

            Registry registry = LocateRegistry.createRegistry(1234);
            registry.bind("SquaresRoots", squaresRootsStub);

            System.out.println("Remote engine started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}