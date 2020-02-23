package io.undervolt.api.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class VEManager {
    private final static VEManager _instance = new VEManager();

    private final Map<VListener, List<Method>> vListeners = new HashMap<>();

    public boolean callVEvent(VEvent e){
        AtomicBoolean tmp = new AtomicBoolean(false);
        this.vListeners.forEach((vl, vm) -> vm.stream().sorted(Comparator.comparing(m -> ((Method)m).getAnnotation(VHandler.class).priority()).reversed()).forEach(m -> {
            try {
                m.invoke(vl, e);
                if(e instanceof VCancellableEvent) {
                    tmp.set(((VCancellableEvent) e).isCancelled());
                }
            } catch (IllegalAccessException | InvocationTargetException ex) {
                System.err.println("[VEM] Failed to invoke method "+e.getClass().getSimpleName());
                ex.printStackTrace();
            }
        }));
        return tmp.get();
    }

    public void linkListener(VListener vl){
        if(!this.vListeners.containsKey(vl)) this.vListeners.put(vl, new ArrayList<>());

        Arrays.stream(vl.getClass().getDeclaredMethods()).filter(m -> (m.isAnnotationPresent(VHandler.class) && m.getParameterTypes().length == 1)).forEach(m -> {
            if(!this.vListeners.get(vl).contains(m)) this.vListeners.get(vl).add(m);
        });
    }

    public void unlinkListener(VListener vl){
        if(this.vListeners.containsKey(vl)) this.vListeners.remove(vl);
    }

    public static VEManager getInstance() {
        return _instance;
    }
}
