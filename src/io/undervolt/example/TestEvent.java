package io.undervolt.example;

import io.undervolt.api.event.VEvent;

public class TestEvent extends VEvent {

    private String message;

    public TestEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
