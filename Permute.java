import java.util.*;

public class Permute implements SymCipher {
    private final int SIZE = 256;
    private byte[] key;
    private byte[] invKey;
    private int temp;

    public Permute(){
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

    public Permute(byte[] bytes)
    {
        this.key = bytes;
    }

    public byte[] getKey()
    {
        return key;
    }


    public byte[] encode(String s)
    {
      
      byte[] msg = s.getBytes();
      byte[] encripted = new byte[msg.length];

      if(msg.length == SIZE || (msg.length % SIZE) != 0 )
        return null;
      // key[65] = 92           invKey[92] = 65
      // byte[65] = 15
      // byte[92] = 15?         decode @ byte 92
      //                        decode[65]         =  15
      //                        decode[invKey[92]] = msg[92]
      for(int i = 0; i < msg.length;i++)
      {
        encripted[(int)(key[i % key.length] & 0xff)] = msg[i];
        //          92
        //byte b1 = key[i];
        //          15
        //byte b2 = (byte)(msg[i] & 0xff);
        //          byte[92] = 15
        //msg[(byte)(key[i] & 0xff)] = (byte)(msg[i] & 0xff);
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

        //byte[]decoded = new byte[encoded.length];
            //  i = 92
        for(int i = 0; i < encoded.length;i++)
        {
            // charTemp = 15 = encoded[i]
            

            encoded[(byte)(invKey[i % key.length] & 0xff)] = encoded[i]; 

        }
        

        return new String(encoded);
    }
}
