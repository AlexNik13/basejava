package main;

import main.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) {
        Resume resume = new Resume();
        String uuidField = "";
        String uuidMethod = "";


        Field field = null;
        try {
            field = resume.getClass().getDeclaredField("uuid");
            field.setAccessible(true);
            field.set(resume, "uuid new");
            uuidField = (String) field.get(resume);
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Method method = null;
        try {
            method = resume.getClass().getDeclaredMethod("toString");
            uuidMethod = (String) method.invoke(resume);
        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println("field uuid: " + uuidField);
        System.out.println("toString: " + uuidMethod);
    }
}
