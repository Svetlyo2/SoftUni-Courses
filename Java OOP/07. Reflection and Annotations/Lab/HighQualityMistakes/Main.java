package HighQualityMistakes;

import CodingTracker.Author;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Reflection.class.getDeclaredMethods();
        TreeSet<Method> getMethods = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> setMethods = new TreeSet<>(Comparator.comparing(Method::getName));
        for (Method method : methods) {
            if (method.getName().startsWith("get") &&
                    method.getParameterCount() == 0) {
                getMethods.add(method);
            } else if (method.getName().startsWith("set") &&
                    method.getParameterCount() == 1 &&
                    void.class.equals(method.getReturnType())) {
                setMethods.add(method);
            }
        }
        Field[] fields = Reflection.class.getDeclaredFields();
        getMethods.stream()
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .forEach(m -> System.out.println(m.getName() + " have to be public!"));
        setMethods.stream()
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .forEach(m -> System.out.println(m.getName() + " have to be private!"));
        Arrays.stream(fields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));
    }
}
