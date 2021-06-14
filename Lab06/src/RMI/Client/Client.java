package RMI.Client;

import RMI.Common.SquaresRoots;
import RMI.Server.SquaresRootsEngine;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1234);
            SquaresRoots squaresRoots = (SquaresRoots) registry.lookup("SquaresRoots");

            List<Double> numbers = Arrays.asList(2.0, 4.0, 16.0);

            List<Double> squares = squaresRoots.getSquares(numbers);
            System.out.println("Server for squares: " + squares);

            List<Double> roots = squaresRoots.getRoots(numbers);
            System.out.println("Server for roots: " + roots);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
