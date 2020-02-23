package io.undervolt.api.event;

public enum VPriority {

    LOW(0), NORMAL(1), HIGH(2), HIGHEST(3), MONITOR(4);

    private int priority;

    VPriority(int priority) {
        this.priority = priority;
    }
}