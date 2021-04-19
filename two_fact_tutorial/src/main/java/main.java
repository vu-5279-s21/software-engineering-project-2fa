
import auth.Utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Scanner;


public class main {
    public static void main(String args[]) {

        // QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK --> static secret key used for testing

        // Generic manual entry
        String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
        // Uncomment for use with (a)
        //String lastCode = null;

        System.out.println("Secret key = " + secretKey + "\n Enter your TOTP, or 'stop' to quit.");

        Scanner sc = new Scanner(System.in);
        String totp = null;

        while (true) {
            String code = Utils.getTOTPCode(secretKey);
            // (a) The following code prints the current TOTP as it updates.
            /*if (!code.equals(lastCode)) {
                System.out.println(code);
            }
            lastCode = code;*/
            totp = sc.nextLine();
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

