package mod3.assignment;

import util.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderTest {

    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
        fileReaderService.read(path)
                .subscribe(Util.subscriber());
    }
}
