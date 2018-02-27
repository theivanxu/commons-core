package com.theivanxu.reflection;

import com.theivanxu.annotation.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xushaonan on 2018/1/10.
 **/
public class BaseRequest {

    public void nullFieldValidation(){
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            Object fieldValue = runGetter(field, this);

//            Annotation annotation = field.getAnnotation(NotNull.class);
            boolean isAnnotationNotNull = field.isAnnotationPresent(NotNull.class);
            if (isAnnotationNotNull && fieldValue == null) {
                System.out.println(fieldName + " can't not be null");
            }
        }

    }

    private Object runGetter(Field field, Object instance) {
        for (Method method : instance.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("get") && method.getName().length() == (field.getName().length() + 3)) {
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase())) {
                    try {
                        return method.invoke(instance);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        System.out.println("could not determine method: " + method.getName());
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        System.out.println("could not determine method: " + method.getName());
                    }
                }
            }
        }
        return null;
    }
}
