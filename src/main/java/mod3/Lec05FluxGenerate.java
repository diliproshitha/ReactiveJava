package mod3;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec05FluxGenerate {

    public static void main(String[] args) {


        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
            synchronousSink.complete();
        })
        .take(3)
        .subscribe(Util.subscriber());
    }
}
