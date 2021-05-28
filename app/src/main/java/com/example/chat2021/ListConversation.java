package com.example.chat2021;

import java.util.ArrayList;

public class ListConversation {
    ArrayList<Conversation> conversations;

    public ArrayList<Conversation> getList(){
        return conversations;
    }



    @Override
    public String toString() {
        return "ListConversation{" +
                "conversations=" + conversations +
                '}';
    }
}
