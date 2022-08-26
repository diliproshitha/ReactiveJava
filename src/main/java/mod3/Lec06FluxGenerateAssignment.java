package mod3;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {

            String country = Util.faker().country().name();

            if (country.toLowerCase().equals("canada")) {
                synchronousSink.complete();
            }
                    synchronousSink.next(country);
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
