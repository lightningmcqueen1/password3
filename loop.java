import java.io.IOException;

public class loop {
    public static void main(String[] args) {
        // Define the characters to use for guessing
        String chars = "abcdefghijklmnopqrstuvwxyz";

        // Loop through all possible combinations of two characters
        for (int i = 0; i < chars.length(); i++) {
            for (int j = 0; j < chars.length(); j++) {
                // Construct the guess string
                String guess = "" + chars.charAt(i) + chars.charAt(j);

                // Print the guess
                System.out.println("Guessing: " + guess);

                try {
                    // Call the external executable and pass the guess as input
                    ProcessBuilder pb = new ProcessBuilder("./script");
                    pb.redirectInput(ProcessBuilder.Redirect.PIPE);
                    pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                    Process p = pb.start();
                    p.getOutputStream().write(guess.getBytes());
                    p.getOutputStream().flush();

                    // Wait for the external executable to finish
                    int exitCode = p.waitFor();

                    // Check if the guess was correct
                    if (exitCode == 0) {
                        System.out.println("Correct guess: " + guess);
                        return;
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        System.out.println("Failed to guess the word.");
    }
}