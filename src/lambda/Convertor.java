package lambda;

public class Convertor {

    @FunctionalInterface
    interface Converteer <F, T>{

        T convert(F form);
    }

    public static void main(String[] args) {
        Converteer<String, Integer> conv = (from -> Integer.valueOf(from));
        Converteer<String, Integer> conv1 = (Integer::valueOf);
        Converteer<String, Integer> conv2 = (f -> Integer.valueOf(f));

        System.out.println(conv.convert("132"));
    }
}
