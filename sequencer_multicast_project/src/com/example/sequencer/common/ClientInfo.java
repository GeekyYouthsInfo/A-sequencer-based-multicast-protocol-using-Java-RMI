package com.example.sequencer.common;

import java.io.Serializable;

public class ClientInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clientId;
    private String username;

    // Constructor
    public ClientInfo(String clientId, String username) {
        this.clientId = clientId;
        this.username = username;
    }

    // Getters and setters
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
