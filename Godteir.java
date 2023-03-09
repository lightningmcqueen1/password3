import java.io.*;

public class Godteir {
    public static void main(String[] args) {
        // Define the characters to use for guessing
        String chars = "abcdefghijklmnopqrstuvwxyz";

        try {
            // Call the external executable
            ProcessBuilder pb = new ProcessBuilder("./script");
            pb.redirectInput(ProcessBuilder.Redirect.PIPE);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process p = pb.start();

            // Loop through all possible combinations of two characters
            for (int i = 0; i < chars.length(); i++) {
                for (int j = 0; j < chars.length(); j++) {
                    // Construct the guess string
                    String guess = "" + chars.charAt(i) + chars.charAt(j);

                    // Print the guess
                    System.out.println("Guessing: " + guess);

                    // Write the guess to the external program's input stream
                    p.getOutputStream().write(guess.getBytes());
                    p.getOutputStream().flush();

                    // Read the output from the external program
                    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String output = reader.readLine();

                    // Check if the guess was correct
                    if (output.equals("login correct")) {
                        System.out.println("Correct guess: " + guess);
                        return;
                    }
                }
            }

            System.out.println("Failed to guess the word.");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}

