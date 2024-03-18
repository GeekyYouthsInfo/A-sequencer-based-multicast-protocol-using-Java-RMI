package com.example.sequencer;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<String> messages;

    public History() {
        messages = new ArrayList<>();
    }

    // Add a message to the history
    public synchronized void addMessage(String message) {
        messages.add(message);
    }

    // Retrieve the entire history
    public synchronized List<String> getHistory() {
        return new ArrayList<>(messages);
    }
}
