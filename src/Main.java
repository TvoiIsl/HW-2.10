import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> {
            U result = condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
            System.out.println(result);
            return result;
        };
    }
    public static void main(String[] args) {

        Predicate<Integer> condition= x -> x %2!=0  ;
        Function<Integer, Integer> ifTrue = x -> x*3;
        Function<Integer, Integer> ifFalse = x -> x*2;
        Function<Integer,Integer> result = ternaryOperator(condition,ifTrue,ifFalse);
        result.apply(9);


        Human andrey = new Human("Andrey", 23, 20.555555555555555555);
        Human vlad = new Human("Vlad", -22, 12.5555555555555);
        Human nikita = new Human("Nikita", 24, 18.9999999999999);
        List<Human> humanList = new ArrayList<>();
        humanList.add(andrey);
        humanList.add(vlad);
        humanList.add(nikita);

        for (Human human : humanList) {

            System.out.println(human);
        }
        System.out.println("Задание 1.1");


        for (Human human : humanList) {

            System.out.println(human);
            System.out.println(new Predicate<Human>() {

                @Override
                public boolean test(Human human) {
                    if (human.getAge() < 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }.test(human));

        }
        System.out.println("Задание 1.2");
        for (Human human : humanList) {
            System.out.println(human);
            System.out.println(((Predicate<Human>) human1 -> {
                if (human1.getAge() < 0) {
                    return false;
                } else {
                    return true;
                }
            }).test(human));

        }
        System.out.println("Задание 2.1");
        for (Human human : humanList) {
            System.out.println(human);
            new Consumer<String>() {
                public void accept(String human1) {
                    System.out.println("Привет, моё имя " + human1);
                }
            }.accept(human.getName());
        }

        System.out.println("Задание 2.2");
        for (Human human : humanList) {
            System.out.println(human);
            ((Consumer<Human>) human1 -> System.out.println("Привет, моё имя " + human1.getName())).accept(human);
        }

        System.out.println("Задание 3.1");
        for (Human human: humanList) {
            System.out.println(human);
            System.out.println(new Function<Double, Float>() {
                @Override
                public Float apply(Double aDouble) {
                    Float a = aDouble.floatValue();
                    return a;
                }
            }.apply(human.getX()));

        }
        System.out.println("Задание 3.2");
        for (Human human : humanList) {
            System.out.println(human);
            System.out.println(((Function<Double, Float>) aDouble -> {
                Float a = aDouble.floatValue();
                return a;
            }).apply(human.getX()));

        }
        System.out.println("Задание 4.1");
        for (Human human: humanList) {
            System.out.println(human);
            System.out.println(new Supplier<Double>() {
                @Override
                public Double get() {
                    return (Math.random() * ((100 - 0) + 1)) + 0;
                }
            }.get());

        }
        System.out.println("Задание 4.2");
        for (Human human : humanList) {
            System.out.println(human);
            System.out.println(((Supplier<Double>) () -> (Math.random() * ((100 - 0) + 1)) + 0).get());

        }
    }

}