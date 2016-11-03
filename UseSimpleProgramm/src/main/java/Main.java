import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ReverseString reverseString = new ReverseString();
        String original = reader.readLine();
        System.out.println(reverseString.reverse(original));
    }
}
