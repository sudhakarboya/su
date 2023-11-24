// Write your code here.

package com.example.player;

public class Player {
    private int id;
    private String name;
    private int jerseyNum;
    private String playerRole;

    public Player(int id, String name, int jerseyNum, String playerRole) {
        this.id = id;
        this.name = name;
        this.jerseyNum = jerseyNum;
        this.playerRole = playerRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNum() {
        return jerseyNum;
    }

    public void setJerseyNum(int jerseyNum) {
        this.jerseyNum = jerseyNum;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }
}
