package org.example.Model;

public class Box {
    private Token token;

    public Box(Token token) {
        this.token = token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
