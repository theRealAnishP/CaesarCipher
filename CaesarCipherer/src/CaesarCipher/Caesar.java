package CaesarCipher;

/**

 * Filename: Caesar.java
 * Created by: Anish Punaroor
 * Email: apunaroo@ucsd.edu
 * Sources of help:
 * File description: This file can encrypt and decrypt a message through
 * the implementation of a rotational cipher. All alphabetical 
 * characters in the message can be rotated by any amount, provided that
 * the rotation amount is an integer. 
 */


/**
 * Name: Caesar
 * Purpose: This class contains the methods that encrypt and decrypt a 
 * message using a rotational cipher. 
 */
public class Caesar {
 
  private static final int ALPHABET_SIZE = 26;
  private static final int UPPERCASE_MAX_VAL = 90; 
  private static final int LOWERCASE_MAX_VAL = 122;
  private static final String EMPTY_STRING = ""; 
    
  /**
   * This method takes in a string and an integer and encrypts the 
   * string by rotating the characters in the string by the rotation 
   * amount. The encrypted string is then returned. The method only 
   * rotates alphabetical characters, and checks for null and empty 
   * string inputs.  
   * 
   * @param encryptStr The string to be encrypted
   * @param rotation The rotation amount 
   * @return The encrypted copy of encryptStr
   */
  public static String encrypt(String encryptStr, int rotation) {
	//check for null input
    if (encryptStr == null){
      return null;  
    }
    //check for empty string
    else if (encryptStr.length() == 0){
      return EMPTY_STRING; 
    }
    //recursively encrypt each character and concatenate them
    char encryptedChar = letterOperation(encryptStr.charAt(0), rotation); 
    return encryptedChar + encrypt(encryptStr.substring(1), rotation);
  }
  
  /**
   * This method takes in a string and an integer and decrypts the string 
   * by rotating the characters in the string by the rotation amount 
   * subtracted from the dize of the alphabet. The decrypted string is 
   * then returned. The method only rotates alphabetical characters, 
   * and checks for null and empty string inputs.  
   * 
   * @param decryptStr The string to be decrypted
   * @param rotation The rotation amount 
   * @return The decrypted copy of decryptStr
   */
  public static String decrypt(String decryptStr, int rotation) {
	//check for null input
    if (decryptStr == null){
      return null;  
    }
    //check for empty string
    else if (decryptStr.length() == 0){
      return EMPTY_STRING; 
    }
    //recursively decrypt each character and concatenate them
    char decryptedChar = letterOperation(decryptStr.charAt(0), 
        ALPHABET_SIZE - rotation);
    return decryptedChar + decrypt(decryptStr.substring(1), rotation);
  }
 
  /**
   * This method returns a character that is rotated when a character 
   * and a rotation amount are passed in. The character is only rotated 
   * if the character is alphabetical.  
   * 
   * @param letter The character being rotated
   * @param rotation The rotation amount 
   * @return The character after being rotated
   */
  private static char letterOperation(char letter, int rotation) {
    char rotatedChar = 0;
    //check for non-alphabetical characters 
    if (Character.isLetter(letter) == false){
      rotatedChar = letter;
    }
    else {
      // convert rotation to positive integer between 0 and 25
      int cipherOffset; 
      if (rotation >= 0){
        cipherOffset = rotation % ALPHABET_SIZE; 
      } 
      else {
        cipherOffset = ALPHABET_SIZE - (Math.abs(rotation) % 
            ALPHABET_SIZE);
      }
      //rotate character if uppercase 
      if (Character.isUpperCase(letter) == true){
        rotatedChar = upperCaseRotator(letter, cipherOffset); 
      }
      //rotate character if lowercase
      else {
        rotatedChar = lowerCaseRotator(letter, cipherOffset);  
      }
    }
    return rotatedChar; 
  }
  
  /**
   * This method returns a uppercase character that is rotated when 
   * a uppercase character and a rotation amount are passed in. The 
   * rotation amount must be between 0 and 25, inclusive. 
   * 
   * @param upLetter The uppercase character being rotated
   * @param upRotation The rotation amount 
   * @return The uppercase character after the rotation
   */
  private static char upperCaseRotator(char upLetter, int upRotation){
    int rotatedUpperCharVal = (int)upLetter + upRotation;  
    // wrap back around to uppercase character range
    if (rotatedUpperCharVal > UPPERCASE_MAX_VAL){
      rotatedUpperCharVal -= ALPHABET_SIZE; 
    }
    char upperChar = (char)rotatedUpperCharVal;  
    return upperChar; 
  }
  
  /**
   * This method returns a lowercase character that is rotated when 
   * a lowercase character and a rotation amount are passed in. The 
   * rotation amount must be between 0 and 25, inclusive. 
   * 
   * @param lowLetter The lowercase character being rotated
   * @param lowRotation The rotation amount 
   * @return The lowercase character after the rotation
   */
  private static char lowerCaseRotator(char lowLetter, int lowRotation){
    int rotatedLowerCharVal = (int)lowLetter + lowRotation;  
    // wrap back around to lowercase character range
    if (rotatedLowerCharVal > LOWERCASE_MAX_VAL){
      rotatedLowerCharVal -= ALPHABET_SIZE; 
    }
    char lowerChar = (char)rotatedLowerCharVal;  
    return lowerChar; 
  }
}
