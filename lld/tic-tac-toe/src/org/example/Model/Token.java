package org.example.Model;

public enum Token {
    X("X"),
    O("O");

    final String val;

    Token(String y) {
        val=y;
    }

    public String toSting() {
        if (this==null) {
            return "--";
        }
        else {
            return this.toString();
        }
    }
}
