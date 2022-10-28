package GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Reflection.class.getDeclaredMethods();
        TreeSet<Method> getMethods = new TreeSet<>((f, s) -> f.getName().compareTo(s.getName()));
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
        getMethods.forEach(method -> System.out.printf("%s will return %s%n", method.getName(), method.getReturnType().getSimpleName()));
        setMethods.forEach(method -> System.out.printf("%s and will set field of %s%n", method.getName(), method.getParameters()[0].getType().getSimpleName()));
    }

}
