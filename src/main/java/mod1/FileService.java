package mod1;

import reactor.core.publisher.Mono;
import util.Util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    public static void main(String[] args) {
//        FileService.read("file01.txt")
//                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

//        FileService.write("file03.txt", "this is file o3")
//                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    public static String readFile(String fileName) {
        try {
            return Files.readString(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(String fileName, String content) {
        try {
            Files.writeString(PATH.resolve(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFile(String fileName) {
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
