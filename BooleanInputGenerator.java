import java.util.ArrayList;
import java.util.List;

public class BooleanInputGenerator {

    public static List<String> generateBooleanInputs(int size) {

        int totalCount = (int) Math.pow(2, size);
        List<String> output = new ArrayList<>();

        for (int i = 0; i < totalCount; i++) {
            String temp = Integer.toBinaryString(i);
            StringBuilder tempBuffer = new StringBuilder();
            int rem = size - temp.length();
            tempBuffer.append("0".repeat(Math.max(0, rem)));
            tempBuffer.append(temp);
            output.add(tempBuffer.toString());
        }

        return output;
    }

}
