package mod4;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec01Handle {

    public static void main(String[] args) {


        Flux.range(1, 10)
                .handle(((integer, synchronousSink) -> {
                    if (integer % 2 == 0) {
                        synchronousSink.next(integer);
                    }
                    else {
                        synchronousSink.next(integer + "a");
                    }

                }))
                .subscribe(Util.subscriber());
    }
}
