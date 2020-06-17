package ua.i.mail100.input;

import ua.i.mail100.settings.Settings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inputer {
    private String question;
    private InputedType type;

    public Inputer(String question, InputedType type) {
        this.question = question;
        this.type = type;
    }

    public <T> T input() throws IOException {
        T input = null;
        System.out.println(question + Settings.LINE_SEP);
        if (type == InputedType.INTEGER) return (T) inputInteger();
        if (type == InputedType.STRING) return (T) inputString();
        if (type == InputedType.STRING_NOT_EMPTY) return (T) inputStringNotEmpty();
        if (type == InputedType.BOOLEAN) return (T) inputBoolean();
        return input;
    }

    private String inputString() throws IOException {
        String result = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (result == null) {
            result = bufferedReader.readLine();
        }
        return result;
    }

    private String inputStringNotEmpty() throws IOException {
        String result = new String();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (result.isEmpty()) {
            result = bufferedReader.readLine();
            if (result.isEmpty()) {
                System.out.println("Value is required");
            }
        }
        return result;
    }

    private Integer inputInteger() throws IOException {
        Integer result = -1;
        while (result != null && result == -1) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = bufferedReader.readLine();
                Pattern pattern = Pattern.compile("(0|[1-9][0-9]*)");
                if (line.length() > 0) {
                    Matcher matcher = pattern.matcher(line);
                    if ( matcher.matches()) {
                        result = Integer.parseInt(line);
                    } else {
                        line = "-";
                        result = Integer.parseInt(line);
                    }
                } else result = null;
            } catch (NumberFormatException e) {
                System.out.println("Bad format - input integer [0, 2147483647] e.g. 10");
            } catch (NullPointerException e) {
                return result;
            }
        }
        return result;
    }

    public Boolean inputBoolean() throws IOException {
        Boolean resultReturn = null;
        Integer temp = -1;
        while (temp != null && temp == -1) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = bufferedReader.readLine();
                Pattern pattern = Pattern.compile("(0|1)");
                if (line.length() > 0) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches()) {
                        resultReturn = (line.equals("1") ? true : false);
                        temp = 1;
                    } else {
                        line = "-";
                        temp = Integer.parseInt(line);
                    }
                } else temp = null;
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
