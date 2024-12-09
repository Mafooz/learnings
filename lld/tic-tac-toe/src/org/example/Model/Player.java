package org.example.Model;

public class Player {
    private String name;
    private int age;
    private Token token;
    public Player(String name, int age, Token token) {
        this.name = name;
        this.age = age;
        this.token = token;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setToken(Token token) {
        this.token = token;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Token getToken() {
        return token;
    }
}
