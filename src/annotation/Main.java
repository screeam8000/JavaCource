package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Coockies a = new Coockies();

        System.out.println(a.getClass()
                .getAnnotation(ControllerObject.class)
                .name());

//        System.out.println(a.getClass().getAnnotations());
//        System.out.println(a.getClass().getAnnotationsByType(ControllerObject.class));

        Annotation[] b = a.getClass().getAnnotations();

        for (Annotation aa: b) {
            if (aa.annotationType().getSimpleName().equalsIgnoreCase("ControllerObject")){

                System.out.println(((ControllerObject)aa).name());
                System.out.println(((ControllerObject)aa).def());
            }
        }

//        System.out.println(a.getClass().getAnnotationsByType(ControllerObject.class));
        Method[] m = a.getClass().getMethods();
        int i=0;
        for (Method mm: m) {

            System.out.println(mm.getName()+ " " + i + " : " +mm.isAnnotationPresent(StartObject.class));
            System.out.println(mm.getName()+ " " + i + " : " +mm.isAnnotationPresent(StopObject.class));
            i++;
        }

    }


}
