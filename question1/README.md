# COP_4502_Assg2

# Running the program
1. Open preffered terminal and navigate to path of file that contains the Main class:
    
2. Compile the program with the following command:
    ```javac Main.java Guests.java Cake.java```
3. Run the compiled program with the followinf command:
    ```java Main```

# Interpreting Output
After the program has begun, there will be some prints to the console that the user can see and check how and which guest is getting the cupcakes.

```There will be a series of print commands indicating weather a guest ate a cupcake or not and then once they all have eaten the cupcake they will notify the Minatour. ```
``` ```

# Proof of correctness
The approach taken was:
the first person goes and doesnt eat the cupcake (they are now the leader) -- assigned to thread 0
second person eats it
third person doesnt request another cupcake (no one can request except leader)
once leader comes back and doesnt see the cupcake, he counts++ and resets the cupcake for next person
lastly once the leader has a count of n-1 he can request a cupcake and eat it

NOTE: only the leader will keep count and notify once they have all had a cupcake
which is when the Minatour will have people stop going in.

Did not have time to check the runtime but i did test with values of 5, 10, 20, and 50 as it was not specified
However it can be notable that for large inputs, this algorithm might take long as it is randomized which guest will go in and it can result in many guests waiting on the leader to order a new cupcake.
For input: In Main please change numGuests  or simply uncomment the scanner for user input.
