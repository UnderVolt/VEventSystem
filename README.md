# EventSystem
An event system for java

# Why ?
Because i don't like at all the EventBus from Google

# Example
Create an Event
```
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
```
Create a Listener
```
import me.kiritodv.event.interfaces.*

public class TestListener implements EListener{
    
    //You can use LOW, NORMAL, HIGH, HIGHEST, MONITOR
    
    @VHandler(priority = VPriority.NORMAL)
    public void onText(TestEvent e){
        System.out.println("Event 1: "+e.getMessage());
    }
   
}
```
Call the event and register the listener
```
    public static void main(String[] args){
        VEManager.getInstance().linkListener(new TestEventListener());
        VEManager.getInstance().callVEvent(new TestEvent("Test Message"));
    }
```

That's it!
