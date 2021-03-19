import java.security.SecureRandom;
//import Base32

public class main {


    //QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK --> secret key

    //generic manual entry
    String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
    String lastCode = null;
    while (true) {
        String code = getTOTPCode(secretKey);
        if (!code.equals(lastCode)) {
            System.out.println(code);
        }
        lastCode = code;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {};
    }

    //QR code stuff
     public static String getGoogleAuthenticatorBarCode(String secretKey, String account, String issuer) {
        try {
            return "otpauth://totp/"
                    + URLEncoder.encode(issuer + ":" + account, "UTF-8").replace("+", "%20")
                    + "?secret=" + URLEncoder.encode(secretKey, "UTF-8").replace("+", "%20")
                    + "&issuer=" + URLEncoder.encode(issuer, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    //test
    String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
    String email = "test@gmail.com";
    String companyName = "My Awesome Company";
    String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
    System.out.println(barCodeUrl);

    //generate QR Code
    public static void createQRCode(String barCodeData, String filePath, int height, int width)
            throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(barCodeData, BarcodeFormat.QR_CODE,
                width, height);
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            MatrixToImageWriter.writeToStream(matrix, "png", out);
        }
    }

    //key generation
    public static String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        return base32.encodeToString(bytes);
    }

    //method to return key
    public static String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }
}