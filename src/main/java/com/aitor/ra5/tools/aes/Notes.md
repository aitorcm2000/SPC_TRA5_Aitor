# AES Tools Notes

### What is this document?

This document is mainly an informative piece of documentation where I study the technologies used in the project, this is just a compilation of notes that I would,  otherwise, take in the project comments but instead I write them here in search of improving the clarity and cleanlines of the code.

#### Variants of AES

| Name    | Key Size | Block Size | Num Rounds |
| ------- | -------- | ---------- | ---------- |
| AES-128 | 128      | 128        | 10         |
| AES-192 | 192      | 128        | 12         |
| AES-256 | 256      | 128        | 14         |

Mainly the difference resides on the size of the Key, a larger **Key Size will result in a better encryption** as a larger key size means that there is a larger possible pool of keys. As the size grows  the number of rounds required for the encryption also does.

The number of possible values are as follows:    $2^{KeySize}$

Which makes a cyber-security attack extremely time cosuming and complicated.

#### Generating AES Keys in Java

1. ##### Defining the Cipher
   
   *private static final String* CIPHER = "AES";

2. ##### Key Generation
   
   1. This is the point where we have to decide if we create a randomly generated key of if we create a password-based key.
   
   2. We will use password-based, as it will be used to cipher user files.
   
   3. What do we need:
      
      1. Cipher
      
      2. Key size
      
      3. Password
      
      4. Sodium Chloride
   
   4. How to
      
      1. An array of about 100 bytes of salt
      
      2. PBEKeySpec
      
      3. SecretKey = Secretkeyfactory.get instance
