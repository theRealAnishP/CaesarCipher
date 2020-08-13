package CaesarCipher; 


import java.util.*;

/*
 * Name:    CaesarTester
 * Purpose: To test Caesar.java for correct output.
 */
public class CaesarTesterMain {

  public static final String initialPrompt = "Choose whether to encrypt or decrypt a message using a rotational cipher. Enter E to encrypt, D to decrypt, and Q to quit.";
  
 /*
  * Name:       main
  * Purpose:    To call and implement methods in Caesar
  * Parameters: String[] args - command line arguments that are unused
  * Return:     void
  */
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in); 
      boolean offsetException = false;
      boolean runProgram = true; 
      
      
      while (runProgram) {
          System.out.println(initialPrompt);
          while (scan.hasNext()) {
          String choice = scan.next(); 
          if (choice.equals("E") || choice.equals("D") || choice.equals("Q")){
              if (choice.equals("E")){
                  System.out.println();
                  System.out.print("Enter the message you want to encrypt: ");
                  String message = scan.next();
                  System.out.println(); 
                  System.out.print("Enter the rotational offset: ");
                  try {
                      int offset = scan.nextInt();
                      String encryptedMessage = Caesar.encrypt(message, offset); 
                      System.out.println(); 
                      System.out.print("Encrypted message: " + encryptedMessage); 
                      System.out.println("\n");
                      break; 
                  }
                  catch (Exception e) {
                      offsetException = true; 
                      System.out.println("Offset must be an integer. Try again.");
                      System.out.println(); 
                      System.out.println(initialPrompt);
                  } 
              }
              else if (choice.equals("D")){
                  System.out.println(); 
                  System.out.print("Enter the message you want to decrypt: "); 
                  String message = scan.next(); 
                  System.out.println();
                  System.out.print("Enter the rotational offset: ");
                  try {
                      int offset = scan.nextInt();
                      String decryptedMessage = Caesar.decrypt(message, offset); 
                      System.out.println(); 
                      System.out.print("Decrypted message: " + decryptedMessage);
                      System.out.println("\n"); 
                      break; 
                  }
                  catch (Exception e) {
                      offsetException = true; 
                      System.out.println("Offset must be an integer. Try again.");
                      System.out.println(); 
                      System.out.println(initialPrompt);
                  }
              }
              else {
                  runProgram = false;
                  break; 
              }
          }
          else { 
              if (offsetException){
                  offsetException = false; 
                  continue; 
              }
              else {
                  System.out.println("Invalid input. Try again."); 
                  System.out.println(); 
                  System.out.println(initialPrompt);
              }
          }
          }
       }
       
       scan.close();
  }

}

