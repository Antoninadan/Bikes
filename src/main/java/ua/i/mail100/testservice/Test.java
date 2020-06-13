package ua.i.mail100.testservice;

import ua.i.mail100.input.InputedType;
import ua.i.mail100.input.Inputer;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.util.DivideUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        int parts = 3;
        int size = integers.size();
        int[][] indexesOfParts = DivideUtil.getIndexesPerParts(size, parts);
        for (int i = 0; i < parts; i++) {
            System.out.println(integers.subList(indexesOfParts[i][0], indexesOfParts[i][1] + 1));
        }
    }
}
