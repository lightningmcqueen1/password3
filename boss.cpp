#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

int main() {
    string guess;
    string command;
    string output;

    // Loop through all possible two-letter combinations and guess the word
    for (char c1 = 'a'; c1 <= 'z'; c1++) {
        for (char c2 = 'a'; c2 <= 'z'; c2++) {
            guess = string(1, c1) + string(1, c2);
            command = "./script " + guess;
            output = system(command.c_str()); // Execute command and capture output
            if (output.find("correct") != string::npos) {
                cout << "Guess: " << guess << " - Word correct" << endl;
                return 0;
            } else {
                cout << "Guess: " << guess << " - Word incorrect" << endl;
            }
        }
    }

    cout << "Could not guess the word" << endl;
    return 0;
}
