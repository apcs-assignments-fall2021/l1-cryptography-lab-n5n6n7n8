import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String ans = "";
        for(int i=0; i<message.length(); i++)
        {
            char letter = message.charAt(i); //the original letter from message
            int letteri = letter; //int tracking which chars to use
            if((letter>='A'&&letter<='Z')||(letter>='a'&&letter<='z')) //is the char in between A-Z or a-z and shift 3
            {
                letteri+=3;
                char newchar = (char) letteri; //the revised char
                if((letteri>='['&&letteri<=']')||(letteri>='{')) // if char is shifted 3 too far in the symbols, subtract 26 to loop around
                {
                    letteri-=26;
                    newchar = (char) letteri;
                }
                ans+=newchar;//add the character to full answer
            }
            else{
                ans+=letter;
            }
        }
        return ans;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String ans = "";
        for(int i=0; i<message.length(); i++)
        {
            char letter = message.charAt(i); //the original letter from message
            int letteri = letter; //int tracking which chars to use
            if((letter>='A'&&letter<='Z')||(letter>='a'&&letter<='z')) //is the char in between A-Z or a-z and shift 3
            {
                letteri-=3;
                char newchar = (char) letteri; //the revised char
                if((letteri<='@')||(letteri>='^'&&letteri<='`')) // if char is shifted 3 too far in the symbols, add 26 to loop around
                {
                    letteri+=26;
                    newchar = (char) letteri;
                }
                ans+=newchar;//add the character to full answer
            }
            else{
                ans+=letter;
            }
        }
        return ans;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String ans = "";
        for(int i=0; i<message.length(); i++)
        {
            char letter = message.charAt(i); //the original letter from message
            int letteri = letter; //int tracking which chars to use
            if((letter>='A'&&letter<='Z')) //is it an uppercase char?
            {
                letteri+=key;
                while(letteri>'Z') // accounts for chars that go over the range of uppercase letters, and keeps subtracting 26 until it is in range
                    {
                        letteri-=26;
                    }
            }
            else if((letter>='a'&&letter<='z')) //is it a lowercase char?
            {
                letteri+=key;
                while(letteri>'z') // accounts for chars that go over that go over the range of lowercase letters, and keeps subtracting 26 until it is in range
                    {
                        letteri-=26;
                    }
            }
            char finalchar = (char) letteri;
            ans+=finalchar;
        }
        return ans;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String ans = "";
        for(int i=0; i<message.length(); i++)
        {
            char letter = message.charAt(i); //the original letter from message
            int letteri = letter; //int tracking which chars to use
            if((letter>='A'&&letter<='Z')) //is it an uppercase char?
            {
                letteri-=key;
                while(letteri<'A') //accounts for chars that go under that go over the range of uppercase letters, and keeps adding 26 until it is in range
                    {
                        letteri+=26;
                    }

            }
            else if((letter>='a'&&letter<='z')) //is it a lowercase char?
            {
                letteri-=key;
                while(letteri<'a') //accounts for chars that go under that go over the range of lowercase letters, and keeps adding 26 until it is in range
                    {
                        letteri+=26;
                    }

            }
            char finalchar = (char) letteri;
            ans+=finalchar;
        }
        return ans;
    }
    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }
        scan.close();
    }
}
