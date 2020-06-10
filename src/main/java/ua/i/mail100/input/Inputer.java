package ua.i.mail100.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO change to regex
public class Inputer {
    private String question;
    private InputedType type;

    public Inputer(String question, InputedType type) {
        this.question = question;
        this.type = type;
    }

    public <T> T input() throws IOException {
        T input = null;

        if (type == InputedType.INTEGER) return (T) inputInteger();
        if (type == InputedType.STRING) return (T) inputString();
        if (type == InputedType.BOOLEAN) return (T) inputBoolean();

        return input;
    }

    private String inputString() throws IOException {
        String result = null;
        System.out.println(question + "\n");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (result == null) {
            result = bufferedReader.readLine();
        }
        return result;
    }


    private Integer inputInteger() throws IOException {
        Integer result = -Integer.MAX_VALUE;
        while (result != null && result == -Integer.MAX_VALUE) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(question + "\n");
            try {
                String line = bufferedReader.readLine();
                result = (line.length() > 0) ? Integer.parseInt(line) : null;
            } catch (NumberFormatException e) {
                System.out.println("Bad command");
            } catch (NullPointerException e) {
                return result;
            }
        }
        return result;
    }

    private Boolean inputBoolean() throws IOException {
        Boolean resultReturn = null;
        Integer result = -Integer.MAX_VALUE;
        while (result != null && result == -Integer.MAX_VALUE) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(question + "\n");
            try {
                String line = bufferedReader.readLine();
                result = (line.length() > 0) ? Integer.parseInt(line) : null;
                if (!result.equals(1) && !result.equals(0)) {
                    result = -Integer.MAX_VALUE;
                    throw new NumberFormatException();
                } else if (result == 1) resultReturn = true;
                else resultReturn = false;
            } catch (NumberFormatException e) {
                System.out.println("Bad command");
            } catch (NullPointerException e) {
                return resultReturn;
            }
        }
        return resultReturn;
    }
}
