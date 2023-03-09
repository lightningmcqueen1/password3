import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class lastShot {
    public static void main(String[] args) throws IOException {
        // Define the command to execute
        String[] cmd = {"./script"};

        // Create a ProcessBuilder to execute the command
        ProcessBuilder pb = new ProcessBuilder(cmd);

        // Redirect the process output to a stream
        pb.redirectErrorStream(true);

        // Start the process and read its output
        Process p = pb.start();
        InputStream is = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Wait for the process to exit and get its exit code
        int exitCode = p.waitFor();
        System.out.println("Process exited with code " + exitCode);
    }
}