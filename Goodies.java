import java.io.*;

public class Goodies{
    public static void main(String[] args) {
        try {
            // Call the external executable
            ProcessBuilder pb = new ProcessBuilder("./script");
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.PIPE);
            Process p = pb.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("enter password:")) {
                    System.out.println(line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}