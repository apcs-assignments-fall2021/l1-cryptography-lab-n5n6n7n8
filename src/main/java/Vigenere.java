import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String ans = "";
        int i2 = 0;//second i to increment through the letters in key
        for(int i=0; i<message.length(); i++)
        {
            char letter = message.charAt(i); //the original char from message
            int letteri = letter; //int tracking which chars to use
            if(letter>='A'&&letter<='Z') //is it uppercase?
            {
                letteri+=convertLetter(key.charAt(i2));//add the int of the key to the output char
                if(letteri>'Z') // accounts for chars that go over the range of uppercase letters, and subtracts 26 so it is in range
                {
                    letteri-=26;
                }
                i2++;
            }
            else if(letter>='a'&&letter<='z')//is it lowercase?
            {
                letteri+=convertLetter(key.charAt(i2));//add the int of the key to the output char
                if(letteri>'z') // accounts for chars that go over the range of lowercase letters, and subtracts 26 so it is in range
                {
                    letteri-=26;
                }
                i2++;
            }
            char finalchar = (char) letteri;
            ans+=finalchar;
            if(i2>=key.length()) //increment 2 resets to zero after key reaches the length
            {
                i2=0;
            }
        }
        return ans;
    }

    public static String decryptVigenere(String message, String key) {
        String ans = "";
        int i2 = 0;//second i to increment through the letters in key
        for(int i=0; i<message.length(); i++)
        {
            char letter = message.charAt(i); //the original char from message
            int letteri = letter; //int tracking which chars to use
            if(letter>='A'&&letter<='Z') //is it uppercase?
            {
                letteri-=convertLetter(key.charAt(i2));//subtract the int of the key to the output char
                if(letteri<'A') // accounts for chars that go under the range of uppercase letters, and adds 26 so it is in range
                {
                    letteri+=26;
                }
                i2++;
            }
            else if(letter>='a'&&letter<='z')//is it lowercase?
            {
                letteri-=convertLetter(key.charAt(i2));//add the int of the key to the output char
                if(letteri<'a') // accounts for chars that go under the range of lowercase letters, and adds 26 so it is in range
                {
                    letteri+=26;
                }
                i2++;
            }
            char finalchar = (char) letteri;
            ans+=finalchar;
            if(i2>=key.length()) //increment 2 resets to zero after key reaches the length
            {
                i2=0;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }
        scan.close();
    }
    public static int convertLetter(char ch)
    {
        return ch - 'A';
    }
}
