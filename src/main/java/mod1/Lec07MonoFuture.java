package mod1;

import reactor.core.publisher.Mono;
import util.Util;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFuture {

    public static void main(String[] args) {
        Mono.fromFuture(Lec07MonoFuture::getName)
                .subscribe(Util.onNext());

        Util.sleepSeconds(3);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
