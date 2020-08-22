//[[ChromeDriver: chrome on XP (013d14ab1ea8b71ca9286d18ceeeb0e9)] -> xpath: //div[@class='mail-Layout-Content']//div[@class='mail-MessageSnippet-Wrapper']/a[@href]]
//---------------------------------------------------------------------------//div[@class='mail-Layout-Content']//div[@class='mail-MessageSnippet-Wrapper']/a[@href]
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {
        String input = "[[ChromeDriver: chrome on XP (013d14ab1ea8b71ca9286d18ceeeb0e9)] -> xpath: //div[@class='mail-Layout-Content']//div[@class='mail-MessageSnippet-Wrapper']/a[@href]]";
        Pattern pattern = Pattern.compile("\\s*(\\s)\\s*");
        String[] words = pattern.split(input);
        System.out.println(words[words.length-1]);
    }
}
