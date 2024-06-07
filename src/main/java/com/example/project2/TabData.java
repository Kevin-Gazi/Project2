package com.example.project2;

public class TabData {
    private String tabName;
    private String chatAreaText;
    private String chatInputText;

    public TabData(String tabName, String chatAreaText, String chatInputText) {
        this.tabName = tabName;
        this.chatAreaText = chatAreaText;
        this.chatInputText = chatInputText;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getChatAreaText() {
        return chatAreaText;
    }

    public void setChatAreaText(String chatAreaText) {
        this.chatAreaText = chatAreaText;
    }

    public String getChatInputText() {
        return chatInputText;
    }

    public void setChatInputText(String chatInputText) {
        this.chatInputText = chatInputText;
    }
}
