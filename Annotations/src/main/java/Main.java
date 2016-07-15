import annotations.Skip;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tparaschiv on 7/15/2016.
 */
public class Main {

    public static void main(String[] args) {
        List<Class> classes = new ArrayList();
        Reflections reflections = new Reflections("tests");

        for (Class<?> cl : reflections.getTypesAnnotatedWith(Skip.class)) {

            Annotation annotation = cl.getAnnotation(Skip.class);
            Skip skip = (Skip) annotation;

            if (skip.enable())
                for(Method method : cl.getDeclaredMethods())
                    try {
                        method.invoke(cl.newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        }
    }
}
