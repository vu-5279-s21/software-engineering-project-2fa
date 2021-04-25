import auth.Utils;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.Scanner;


public class main {
    public static void main(String args[]) throws IOException, WriterException {

        // Static secret key used for testing.
        // QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK

        // Generate secretKey.
        String secretKey = Utils.generateSecretKey();

        // Display secretKey for user to input into authenticator app.
        System.out.println("Secret key = " + secretKey + "\n Enter your TOTP, or 'stop' to quit.");


        String email = "test@gmail.com";
        String companyName = "Test Company";
        String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
        Utils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);

        Scanner sc = new Scanner(System.in);
        String totp = null;

        while (true) {
            String code = Utils.getTOTPCode(secretKey);
            // Accept user inputted code
            totp = sc.nextLine();
            // Check for validity and print feedback. Exit if 'stop' is input.
            if (totp.equals(code)) {
                System.out.println("Authentication Success");
            }
            else if (totp.equalsIgnoreCase("Stop")) {
                System.out.println("Stopping authenticator...");
                break;
            }
            else {
                System.out.println("Authentication Failure");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {break;}
        }

    }

}

