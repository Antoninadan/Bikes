package ua.i.mail100.testservice;

import ua.i.mail100.input.ElectroBikeInputer;

import java.io.IOException;

public class TestInput {
    public static void main(String[] args) throws IOException {
//        Boolean price = new Inputer("Input light", InputedType.BOOLEAN).input();
//
//        System.out.println(price);

        ElectroBikeInputer.inputEBike();
    }
}
