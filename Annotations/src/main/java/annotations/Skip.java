package annotations;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by tparaschiv on 7/15/2016.
 */
@Retention(value = RUNTIME)
public @interface Skip {
    boolean enable() default false;
}
