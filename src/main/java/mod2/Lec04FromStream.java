package mod2;

import reactor.core.publisher.Flux;
import util.Util;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FromStream {

    public static void main(String[] args) {


        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Stream<Integer> stream = list.stream();

//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);

        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());

        integerFlux.subscribe(Util.onNext());
        integerFlux.subscribe(Util.onNext());
    }
}
