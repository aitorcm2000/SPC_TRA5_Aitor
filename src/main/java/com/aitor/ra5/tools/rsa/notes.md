# RSA Tools Notes

### What is this document?

This document is mainly an informative piece of documentation where I study the technologies used in the project, this is just a compilation of notes that I would, otherwise, take in the project comments but instead I write them here in search of improving the clarity and cleanlines of the code.



#### What is RSA?

RSA is an asymmetric  or public key cryptographic algorithm, this is implies the use  of two sets of keys : A Private Key and a Public Key.

The algorithm has three main parts:

1. Key Generation.

2. Encryption

3. Decryption

An example of an exchange through RSA would be as follows:

            Sender---------------------------Receiver

1. Receiver sends its Public Key

2. Sender encrypts the message with Receiver's Public Key 

3. Sender sends the message to Receiver

4. Receiver decrypts the message using its own Private Key



#### Knowledge gathered - Let's make it work

1. ###### Key Generation
   
   1. *KeyPairGenerator* generator = *KeyPairGenerator.getInstance* ("RSA");
   
   2. generator.*initialize(2048)*
   
   3. *KeyPair* pair = generator.*generateKeyPair()*;
   
   4. *PrivateKey*  privateKey = pair.*getPrivate()*;
   
   5. *PublicKey* publicKey = pair.*getPublic()*;
   
   6. Usually this types of keys are stored in files for later use.
      
      1. Write the encoded of the key on a file.
      
      2. To read the key we need to read the bytes from the file.
      
      3. Once we have the bytes form the file we need to encode the bytes creating an object of EncodeTypeSpec using x509EncodeKeySpec.
      
      4. Then generate using KeyFactory 

2. ###### Encryption
   
   1. String Encryption
      
      1. In the case of RSA, the initiation of the cipher requires the public key of the receiver.
      
      2. Then we get the bytes on the message and doFinal with them.
   
   2. File Encryption
      
      1. 

3. ###### Decryption
   
   1. String Decryption
      
      1. Setting the cipher with decrypt mode and the private key.
      
      2. doFinal to the bytes of the encrypted message and create a new String with them and the desired charset
      
      3. We can verify the proess through assertEquals
   
   2. 


