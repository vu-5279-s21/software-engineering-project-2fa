
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

        Scanner sc = new Scanner(System.in);

        // QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK --> static secret key used for testing

        // Get secretKey from user.
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

