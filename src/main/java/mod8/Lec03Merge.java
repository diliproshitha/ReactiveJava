package mod8;

import mod8.helper.AmericanAirlinesFlights;
import mod8.helper.EmirateFlights;
import mod8.helper.QuatarFlights;
import reactor.core.publisher.Flux;
import util.Util;

public class Lec03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                QuatarFlights.getFlights(),
                EmirateFlights.getFlights(),
                AmericanAirlinesFlights.getFlights()
        );

        merge.subscribe(Util.subscriber());

    }
}
