package mod3;

import mod3.helper.NameProducer;
import reactor.core.publisher.Flux;
import util.Util;

public class Lec08FluxPush {

    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
