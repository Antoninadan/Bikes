package ua.i.mail100.input;

import ua.i.mail100.settings.Settings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        if (type == InputedType.STRING_NOT_EMPTY) return (T) inputStringNotEmpty();
        if (type == InputedType.BOOLEAN) return (T) inputBoolean();

        return input;
    }

    private String inputString() throws IOException {
        String result = null;
        System.out.println(question + Settings.LINE_SEP);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (result == null) {
            result = bufferedReader.readLine();
        }
        return result;
    }

    private String inputStringNotEmpty() throws IOException {
        String result = new String();
        System.out.println(question + Settings.LINE_SEP);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (result.isEmpty()) {
            result = bufferedReader.readLine();
            if (result.isEmpty()) {
                System.out.println("Value must be filled");
            }
        }
        return result;
    }

    private Integer inputInteger() throws IOException {
        Integer result = -Integer.MAX_VALUE;
        while (result != null && result == -Integer.MAX_VALUE) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(question + Settings.LINE_SEP);
            try {
                String line = bufferedReader.readLine();
                result = (line.length() > 0) ? Integer.parseInt(line) : null;
            } catch (NumberFormatException e) {
                System.out.println("Bad format - input integer e.g. 10");
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
            System.out.println(question + Settings.LINE_SEP);
            try {
                String line = bufferedReader.readLine();
                result = (line.length() > 0) ? Integer.parseInt(line) : null;
                if (!result.equals(1) && !result.equals(0)) {
                    result = -Integer.MAX_VALUE;
                    throw new NumberFormatException();
                } else if (result == 1) resultReturn = true;
                else resultReturn = false;
            } catch (NumberFormatException e) {
                System.out.println("Bad command - true = 1, false = 0");
            } catch (NullPointerException e) {
                return resultReturn;
            }
        }
        return resultReturn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = type.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = question.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = type.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Inputer other = (Inputer) obj;
        if (!question.equals(other.question)) return false;
        if (type.ordinal() != other.type.ordinal()) return false;
        return true;
    }
}
