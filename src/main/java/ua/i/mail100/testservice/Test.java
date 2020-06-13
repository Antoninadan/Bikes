package ua.i.mail100.testservice;

import ua.i.mail100.input.InputedType;
import ua.i.mail100.input.Inputer;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;
import ua.i.mail100.representative.BikeCollection;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        Inputer inputerOne;
        Inputer inputerTwo;
        Inputer inputerThree;
        Inputer inputerFour;

        inputerOne = new Inputer("1", InputedType.STRING);
        inputerTwo = new Inputer("1", InputedType.STRING);
        inputerThree = new Inputer("1", InputedType.STRING_NOT_EMPTY);
        inputerFour = new Inputer("2", InputedType.STRING);


    }
}
