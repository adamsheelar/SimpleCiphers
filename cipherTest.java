import java.util.Scanner;


final public class cipherTest {
    private static Scanner sc;
    
    public static void main(String[] args)
    {
       sc = new Scanner(System.in);
       System.out.println("Which method would you like to use?");
       System.out.println("1. Add");
       System.out.println("2. Substitute");
       System.out.println("3. Permute.");

       int choice = sc.nextInt();
       if(choice == 1)
       {
           add128Test(sc);
       } else if (choice == 2)
       {
            substituteTest(sc);
       } else if(choice == 3){
           
            permuteTest(sc);
       }
        
        

    }

    public static void add128Test(Scanner sc)
    {
        System.out.println("TESTING ADD128.");
        System.out.println("Creating new private key...");
        Add128 add = new Add128();
        //System.out.println("Displaying key. \n" + add.getKey);
        System.out.println("Encoding msg Hello");
        byte[] encoded = add.encode("Hello");
        System.out.println(encoded.toString());
        System.out.println("Decoding message now.");
        System.out.println(add.decode(encoded));


        
        String input=""; 

        while(true){
            System.out.println("Enter a message to encode and decode.");
            System.out.println("Enter -1 to exit.");
            input = sc.nextLine();
            if(input.equals("-1"))
            {
                break;
            }
            System.out.println("Encoding msg");
            encoded = add.encode(input);
            System.out.println(encoded.toString());
            System.out.println("Decoding message now.");
            System.out.println(add.decode(encoded));
        }
    }


    public static void substituteTest(Scanner sc)
    {
        System.out.println("TESTING SUBSTITUTE.");
        System.out.println("Creating new private key...");
        Substitute sub = new Substitute();
        
        System.out.println("Encoding msg Hello");
        byte[] encoded = sub.encode("Hello");
        System.out.println(encoded.toString());
        System.out.println("Decoding message now.");
        System.out.println(sub.decode(encoded));


        
        String input=""; 

        while(true){
            System.out.println("Enter a message to encode and decode.");
            System.out.println("Enter -1 to exit.");
            input = sc.nextLine();
            if(input.equals("-1"))
            {
                break;
            }
            System.out.println("Encoding msg");
            encoded = sub.encode(input);
            System.out.println(encoded.toString());
            System.out.println("Decoding message now.");
            System.out.println(sub.decode(encoded));
        }
    }
    public static void permuteTest(Scanner sc)
    {
        System.out.println("TESTING PERMUTE.");
        System.out.println("Creating new private key...");
        Permute per = new Permute();
        
        System.out.println("Encoding msg Hello");
        byte[] encoded = per.encode("Hello");
        System.out.println(encoded.toString());
        System.out.println("Decoding message now.");
        System.out.println(per.decode(encoded));


        
        String input=""; 

        while(true){
            System.out.println("Enter a message to encode and decode.");
            System.out.println("Enter -1 to exit.");
            input = sc.nextLine();
            if(input.equals("-1"))
            {
                break;
            }
            System.out.println("Encoding msg");
            encoded = per.encode(input);
            System.out.println(encoded.toString());
            System.out.println("Decoding message now.");
            System.out.println(per.decode(encoded));
        }
    }
   
}




