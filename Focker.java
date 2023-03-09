import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Focker {
    public static void main(String[] args) throws IOException {
        // Define the possible characters for the password
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // Create child process
        Process child;

        // Get input and output streams for child process
        BufferedReader in;
        OutputStream out;
        
        // Try all possible combinations of two characters
           String sesh;
		   for(char c1 : chars)
		   {
            for (char c2 : chars) {
                // Generate next guess
				child = Runtime.getRuntime().exec("./script");

        // Get input and output streams for child process
                in = new BufferedReader(new InputStreamReader(child.getInputStream()));
                out = child.getOutputStream();
				sesh = in.readLine();
                String guess = "" + c1 + c2;
                System.out.println("Guessing " + guess);

                // Send guess to child process
                out.write(guess.getBytes());
                out.write('\n'); // write a newline to signal end of input
                out.flush();
                   
                // Wait for response from child process
                String response = in.readLine();

                if (response != null && response.contains("login correct")) {
                    System.out.println("The password is " + guess);
                    return;
                }
				
            }
		   }
		
	  
        // If we get here, we didn't find the password
        System.out.println("Unable to guess the password.");
    }
}