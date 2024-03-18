/*    We have a constructor to initialize the Group with a multicast address.
    We provide methods to join and leave the multicast group.
    The multicastMessage method sends a message to all sequencers in the group using multicast sockets.
     */

package com.example.sequencer;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Group extends UnicastRemoteObject {
    private static final long serialVersionUID = 1L;

    private List<Sequencer> sequencers;
    private String multicastAddress;

    public Group(String multicastAddress) throws RemoteException {
        super();
        this.multicastAddress = multicastAddress;
        sequencers = new ArrayList<>();
    }

    // Method to join the multicast group
    public void joinGroup(Sequencer sequencer) throws RemoteException {
        sequencers.add(sequencer);
        System.out.println("Sequencer joined the group.");
    }

    // Method to leave the multicast group
    public void leaveGroup(Sequencer sequencer) throws RemoteException {
        sequencers.remove(sequencer);
        System.out.println("Sequencer left the group.");
    }

    // Method to multicast a message to all sequencers in the group
    public void multicastMessage(String message) {
        try {
            MulticastSocket socket = new MulticastSocket();
            InetAddress group = InetAddress.getByName(multicastAddress);

            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, group, 12345); // Change port if needed

            socket.send(packet);
            socket.close();

            System.out.println("Message multicasted to the group: " + message);
        } catch (Exception e) {
            System.err.println("Error multicasting message: " + e.getMessage());
        }
    }
}
