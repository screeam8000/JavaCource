package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Coockies a = new Coockies();

        Field[] fs = a.getClass().getFields();

        for(Field f:fs) {

            if(f.getDeclaredAnnotation(ControllerObject.class).def()==34){

                Method [] ms = a.getClass().getDeclaredMethods();

                for (Method m:ms){

                    if(m.getName().equals("set"+"color")){

                        m.invoke(a, "123");
                    }
                }
            }
        }

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
