import java.math.*;
import java.util.*;

public class Substitute implements SymCipher{
    private final int SIZE = 256;
    private byte[] key;
    
    public Substitute()
    {
        key = new byte[256];
		for(int i = 0; i < key.length; i++)
		{
			key[i] = (byte)i; 
		}
		for(int i = 0; i < 512; i++)//shuffle
		{
			Random rand1 = new Random();
			Random rand2 = new Random();
			int randNum1 = rand1.nextInt(256);
			int randNum2 = rand2.nextInt(256);
			byte temp;
			temp = key[randNum1];
			key[randNum1] = key[randNum2];
			key[randNum2] = temp;
		}
    }

    public Substitute(byte[] bytes )
    {
        this.key = bytes;
    
    }

    public byte[] getKey()
    {
        return key;
    }

    public byte[] encode(String s)
    {
        byte [] msg = s.getBytes();
		byte [] encripted = new byte[msg.length];
		for(int i = 0; i < msg.length; i++)
		{
			encripted[i] = key[(int)(msg[i] & 0xff)];
		}
		return encripted;
    }

    public String decode(byte[] encoded)
    {

        byte[] inverseKey = new byte[256];
		for(int i = 0; i < key.length; i++)
		{
			inverseKey[(int)(key[i] & 0xff)] = (byte)i;
		}
        byte[] decoded = new byte[encoded.length];
        for(int i = 0; i< encoded.length;i++)
        {
            decoded[i] = inverseKey[(int)(encoded[i] & 0xff)]; 
        }
        return new String(decoded);
    }


}