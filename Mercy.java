import java.io.*;

public class Mercy {
    public static void main(String[] args) {
        // Define the characters to use for guessing
        String chars = "abcdefghijklmnopqrstuvwxyz";

        try {
            // Call the external executable
            ProcessBuilder pb = new ProcessBuilder("./script");
            pb.redirectInput(ProcessBuilder.Redirect.PIPE);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process p = pb.start();
 			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String output = reader.readLine();
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}

