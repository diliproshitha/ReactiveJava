package mod8;

import mod8.helper.NameGenerator;
import util.Util;

import java.util.Locale;

public class Lec01StartWith {

    public static void main(String[] args) {


        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));

        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        nameGenerator.generateNames()
                .filter(item -> item.toLowerCase().startsWith("a"))
                .take(3)
                .subscribe(Util.subscriber("jake"));


    }
}
