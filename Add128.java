import java.util.*;
import java.math.*;
 public class Add128 implements SymCipher{
    public byte[] addKey;
    private final int SIZE = 128;

    public Add128()
    {
        Random rand = new Random();
		addKey = new byte[128];
		rand.nextBytes(addKey);

    }

    public Add128(byte[]arr)
    {
        
        this.addKey = arr;
    }

    // Return an array of bytes that represent the key for the cipher
    public byte[] getKey(){
        return this.addKey;
    }

    // Encode the string using the key and return the result as an array of
	// bytes.  Note that you will need to convert the String to an array of bytes
	// prior to encrypting it.  Also note that String S could have an arbitrary
	// length, so your cipher may have to "wrap" when encrypting or return
	// null if the size is not correct.
    public byte[] encode(String s ){
        
        byte[] encoded = s.getBytes();
       for(int i = 0; i<encoded.length;i++)
       {
           encoded[i] += addKey[i % addKey.length];
       }
        return encoded;


    }

    // Decrypt the array of bytes and generate and return the corresponding String.
	// Also note that the bytes array could have an arbitrary
	// length, so your cipher may have to "wrap" when decrypting or return
	// null if the size is not correct.
    public String decode(byte[]bytes)
    {
        byte[] decode = new byte[bytes.length];
        System.arraycopy(bytes, 0, decode, 0, bytes.length);
        for(int i = 0 ; i < decode.length; i++)
        {
            decode[i] -= addKey[i% addKey.length];
        }
        
        return new String(decode);

    }
}