# COP_4502_Assg2

# Running the program
1. Open preffered terminal and navigate to path of file that contains the Main class:
    
2. Compile the program with the following command:
    ```javac Main.java Guests.java Showroom.java```
3. Run the compiled program with the following command:
    ```java Main```

# Interpreting Output
As the program runs the user can see which thread is entering the showroom, when they are in it and once they leave.

```There will be a series of print commands indicating weather the showroom is available or not and then once they all have seen the vase they will notify the Minatour. ```
``` ```

# Proof of correctness
The approach taken was:
We took the second approach as described in the assignment description. Each guest will enter the room only once available and they will change the sing to BUSY so that other guests do not try to go in. Once they go out, they will once again change the sign and the nexg guess waiting can go in and see the vase.

NOTE: In this case the minotaur does not need to notify the guests once they have all seen the vase as they will all go see it only once(its not that impressive apparently)

Did not have time to check the runtime but i did test with values of 5, 10, 20, and 50 as it was not specified
For input: the program will ask the use.
