package org.example.exception;

import lombok.ToString;

@ToString
public class BattleException extends Exception {
    private String errorDescription;
    public BattleException(String description) {
        this.errorDescription = description;
    }
}
