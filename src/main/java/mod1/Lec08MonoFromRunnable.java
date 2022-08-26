package mod1;

import reactor.core.publisher.Mono;
import util.Util;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        Mono.fromRunnable(getName())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process is done. Sending emails...");
                        }
                );
    }

    private static Runnable getName() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Process is comleted");
        };
    }
}
