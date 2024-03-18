
/*    We initialize lists to store registered clients and chat history.
    The multicast method adds the received message to the chat history.
    The registerClient method adds a client to the list of registered clients.
    The unregisterClient method removes a client from the list of registered clients.
    The getChatHistory method returns the current chat history. */




    package com.example.sequencer;

    import java.rmi.RemoteException;
    import java.rmi.server.UnicastRemoteObject;
    import java.util.ArrayList;
    import java.util.List;

    import com.example.sequencer.common.ClientInfo;
    
    public class SequencerImpl extends UnicastRemoteObject implements Sequencer {
        private static final long serialVersionUID = 1L;
    
        // List to store registered clients
        private List<ClientInfo> clients;
    
        // List to store chat history
        private List<String> chatHistory;
    
        public SequencerImpl() throws RemoteException {
            super();
            clients = new ArrayList<>();
            chatHistory = new ArrayList<>();
        }
    
        @Override
        public void multicast(String message) throws RemoteException {
            // Implement multicast logic here
            System.out.println("Received message: " + message);
            chatHistory.add(message);
            // Add logic to multicast the message to all clients
        }
    
        @Override
        public void registerClient(ClientInfo clientInfo) throws RemoteException {
            clients.add(clientInfo);
            System.out.println("Client registered: " + clientInfo.getUsername());
        }
    
        @Override
        public void unregisterClient(ClientInfo clientInfo) throws RemoteException {
            clients.remove(clientInfo);
            System.out.println("Client unregistered: " + clientInfo.getUsername());
        }
    
        @Override
        public List<String> getChatHistory() throws RemoteException {
            return chatHistory;
        }
    }
    