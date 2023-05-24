import domain.City;
import domain.LocalityWorld;
import domain.Village;
import util.CsvReader;
import util.SerializeUtils;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You must specify data file name and serialize file name!");
            return;
        }

        String sourceFile = args[0];
        String binFile = args[1];

        List<String[]> strings = CsvReader.readCsvFile(sourceFile, ";");
        List<LocalityWorld> locality = new ArrayList<>();
        for (String[] line : strings) {
            if (line[0].equals("0")) {
                locality.add(new City(line));
            } else {
                locality.add(new Village(line));
            }
        }

        locality.forEach(System.out::println);

        SerializeUtils.serialize(locality, binFile);
        List<LocalityWorld> newLocality = (List<LocalityWorld>) SerializeUtils.deserialize(binFile);
        System.out.println("Новые города: ");
        newLocality.forEach(System.out::println);
    }
}