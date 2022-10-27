package Refl1;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
//        Class<Refl1.GettersAndSetters.HighQualityMistakes.Reflection> clazz = Refl1.GettersAndSetters.HighQualityMistakes.Reflection.class;
//        System.out.println("This class type: " + clazz);
//        System.out.println("Super class type: " + clazz.getSuperclass());
//        Class[] interfaces = clazz.getInterfaces();
//        Arrays.stream(interfaces).forEach(i-> System.out.println("Interface: " +i));
//        Refl1.GettersAndSetters.HighQualityMistakes.Reflection ref=clazz.getDeclaredConstructor().newInstance();
//        System.out.println(ref);
//        Refl1.GettersAndSetters.HighQualityMistakes.Reflection reflection=(Refl1.GettersAndSetters.HighQualityMistakes.Reflection) Class.forName(Refl1.GettersAndSetters.HighQualityMistakes.Reflection.class.getName()).getConstructor().newInstance();
        System.out.println("This class type: " + Reflection.class);
        System.out.println("Super class type: " + Reflection.class.getSuperclass());
        Class[] interfaces = Reflection.class.getInterfaces();

        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("Interface: " + interfaces[i]);
        }

        Reflection reflection = (Reflection) Class.forName(Reflection.class.getName()).getConstructor().newInstance();
        System.out.println(reflection);

    }
}
