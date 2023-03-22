#include <iostream>
#include <string>

using namespace std;

int main() {
    string word;
    string guess;

    cout << "Enter word: ";
    cin >> word;

    // Loop through all possible two-letter combinations and guess the word
    for (char c1 = 'a'; c1 <= 'z'; c1++) {
        for (char c2 = 'a'; c2 <= 'z'; c2++) {
            guess = string(1, c1) + string(1, c2);
            cout << "Guessing: " << guess << endl;
            if (guess == word) {
                cout << "Word correct" << endl;
                return 0;
            } else {
                cout << "Word incorrect" << endl;
            }
        }
    }

    cout << "Could not guess the word" << endl;
    return 0;
}
