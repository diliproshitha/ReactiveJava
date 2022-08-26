package mod3;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec01FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {

            String country;

            while(true) {
                country = Util.faker().country().name();
                if (country.toLowerCase().equals("canada")) {
                    break;
                }
                fluxSink.next(country);
            }

            fluxSink.complete();
        })
        .subscribe(Util.subscriber());
    }
}
