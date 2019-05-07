package com.gabrielleopoldino.simpleusercrud.model;

public class User {

    private int index;
    private String username;

    public User(int index, String username) {
        this.index = index;
        this.username = username;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
}