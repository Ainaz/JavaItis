
public class ReverseString {

    public String reverse(String original){
        StringBuffer stringBuffer = new StringBuffer(original);
        String reverse = stringBuffer.reverse().toString();
        return reverse;
    }
}
