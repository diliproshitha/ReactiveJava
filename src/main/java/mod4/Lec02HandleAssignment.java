package mod4;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec02HandleAssignment {

    public static void main(String[] args) {


        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
        })
                .map(Object::toString)
                .handle(((s, synchronousSink) -> {
                    synchronousSink.next(s);

                    if ("canada".equals(s.toLowerCase())) {
                        synchronousSink.complete();
                    }
                }))
                .subscribe(Util.subscriber());
    }
}
