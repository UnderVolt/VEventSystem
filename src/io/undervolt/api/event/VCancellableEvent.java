package io.undervolt.api.event;

public class VCancellableEvent extends VEvent {

    protected boolean cancelled;

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
