package mod8;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec04Zip {

    public static void main(String[] args) {

        Flux.zip(getBody(), getEngine(), getTyres())
                .subscribe(Util.subscriber());

    }

    private static Flux<String> getBody() {
        return Flux.range(1, 5)
                .map(i -> "body");
    }

    private static Flux<String> getEngine() {
        return Flux.range(1, 2)
                .map(i -> "engine");
    }

    private static Flux<String> getTyres() {
        return Flux.range(1, 6)
                .map(i -> "tires");
    }
}
