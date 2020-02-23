package io.undervolt.api.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface VHandler {
    VPriority priority() default VPriority.NORMAL;
}
