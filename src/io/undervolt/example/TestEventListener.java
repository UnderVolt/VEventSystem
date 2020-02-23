package io.undervolt.example;

import io.undervolt.api.event.VEManager;
import io.undervolt.api.event.VHandler;
import io.undervolt.api.event.VListener;
import io.undervolt.api.event.VPriority;

public class TestEventListener extends VListener {

    public static void main(String[] args){
        VEManager.getInstance().linkListener(new TestEventListener());
        VEManager.getInstance().callVEvent(new TestEvent("owo"));
    }

    @VHandler(priority = VPriority.HIGH)
    public void onText(TestEvent e){
        System.out.println("Event 1: "+e.getMessage());
    }

    @VHandler(priority = VPriority.HIGHEST)
    public void onText3(TestEvent e){
        System.out.println("Event 3: "+e.getMessage());
    }

    @VHandler(priority = VPriority.LOW)
    public void onText2(TestEvent e){
        System.out.println("Event 2: "+e.getMessage());
    }
}
