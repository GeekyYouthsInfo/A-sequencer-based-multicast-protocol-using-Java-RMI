/*    We prompt the user to enter their username.
    We obtain the sequencer object from the registry.
    We register the client with the sequencer using a unique client ID and the entered username.
    We allow the user to continuously enter messages to be multicasted to the sequencer until they type "exit".
    Finally, we unregister the client from the sequencer. */

package com.example.sequencer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.example.sequencer.common.ClientInfo;

public class TestSequencer {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            // Locate the registry and obtain the sequencer object
            Registry registry = LocateRegistry.getRegistry(null); // Change if needed
            Sequencer sequencer = (Sequencer) registry.lookup("Sequencer");

            // Register the client with the sequencer
            ClientInfo clientInfo = new ClientInfo("uniqueClientId", username);
            sequencer.registerClient(clientInfo);

            // Interaction with the sequencer
            while (true) {
                System.out.print("Enter your message ('exit' to quit): ");
                String message = scanner.nextLine();

                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                // Multicast the message to the sequencer
                sequencer.multicast(message);
            }

            // Unregister the client from the sequencer
            sequencer.unregisterClient(clientInfo);

            scanner.close();
        } catch (Exception e) {
            System.err.println("TestSequencer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
