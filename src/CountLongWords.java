import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("./gutenberg/alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        Long count = 0L;
        for (String w:words) {
            if (w.length() > 12){
                count++;
            }
        }
        System.out.println(count);

        count = words.stream().filter(item -> item.length() > 12).count();
        System.out.println(count);
    }
}