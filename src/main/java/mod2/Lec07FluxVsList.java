package mod2;

import mod2.helper.NameGenerator;
import util.Util;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {

//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        NameGenerator.getNamesFlux(5)
                .subscribe(Util.onNext());
    }
}
