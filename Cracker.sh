#!/bin/bash

password_file="./passwords.txt" # File to write passwords to
executable="./script"           # Executable file to test passwords against

# Generate all possible two-character passwords
for i in {a..z}{a..z}; do
  # Attempt to run the executable with the password
  echo "$i" | $executable > /dev/null

  # Check the exit status of the executable
  if [[ $? -eq 0 ]]; then
    echo "Password is $i"
    echo "$i" > $password_file
    exit 0
  fi
done

echo "Password not found"