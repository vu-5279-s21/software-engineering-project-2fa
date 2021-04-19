import auth.Utils;
import java.util.Scanner;


public class main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Static secret key used for testing.
        // QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK

        // Get secretKey from user. Exit if 'stop' is input.
        System.out.println("Enter secret key, or 'stop' to quit.");
        String secretKey = sc.nextLine();
        if (secretKey.equalsIgnoreCase("stop")) {
            return;
        }

        String lastCode = null;

        while (true) {
            // Generate code based on secret encryption key.
            String code = Utils.getTOTPCode(secretKey);
            // If code has updated, print new code.
            if (!code.equals(lastCode)) {
                System.out.println(code);
            }
            // Update code
            lastCode = code;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {break;}
        }

    }


}

