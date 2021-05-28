package com.example.chat2021;

import java.util.ArrayList;

public class ListMessage {
    ArrayList<Message> messages;

    public ArrayList<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "ListMessage{" +
                "conversations=" + messages +
                '}';
    }
}
