package com.example.sequencer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.example.sequencer.common.ClientInfo;

public interface Sequencer extends Remote {
    void multicast(String message) throws RemoteException;

    // Method to register a client with the sequencer
    void registerClient(ClientInfo clientInfo) throws RemoteException;

    // Method to unregister a client from the sequencer
    void unregisterClient(ClientInfo clientInfo) throws RemoteException;

    // Method to retrieve the current state of the chat room
    List<String> getChatHistory() throws RemoteException;
    
    // Other methods as needed for total ordering, heartbeat, etc.
}
