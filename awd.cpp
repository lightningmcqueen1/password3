#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

int main() {
    string words[676]; // Array to store all possible two-letter combinations
    char c1 = 'a';
    char c2 = 'a';
    int i = 0;

    // Generate all possible two-letter combinations
    for (int j = 0; j < 26; j++) {
        c1 = 'a' + j;
        for (int k = 0; k < 26; k++) {
            c2 = 'a' + k;
            words[i] = string(1, c1) + string(1, c2);
            i++;
        }
    }

    // Loop through all possible combinations and execute script
    for (int j = 0; j < 676; j++) {
        string command = "./script " + words[j]; // Replace "script" with the name of your executable file
        FILE* pipe = popen(command.c_str(), "r"); // Open pipe to command and capture output
        if (!pipe) {
            cerr << "Error: Failed to open pipe to command." << endl;
            return 1;
        }

        char buffer[128];
        string output = "";
        while (fgets(buffer, 128, pipe)) {
            output += buffer;
        }

        int exit_status = pclose(pipe);
        if (exit_status == 0 && output == "word correct\n") {
            cout << "Correct word is: " << words[j] << endl;
            break;
        }
    }

    return 0;
}
