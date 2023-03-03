import java.io.*;

public class Runyay {
    public static void main(String[] args) {
        String absolutePath = new File("").getAbsolutePath()+ "//script";
        try {
            Process process = Runtime.getRuntime().exec(absolutePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

