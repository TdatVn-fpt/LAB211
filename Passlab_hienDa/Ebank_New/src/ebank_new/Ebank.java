
package ebank_new;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author ADMIN
 */
public class Ebank {
    
    private ArrayList<Account> listAcc = new ArrayList<>();
    
    public Ebank() {
        datauser();
    }
    
    private void datauser() {
        listAcc.add(new Account("0985109174", "A0985109174"));
        listAcc.add(new Account("2693117624", "B123489751"));
        listAcc.add(new Account("3693187623", "C123489751"));
        listAcc.add(new Account("4635187622", "D123389751"));
        listAcc.add(new Account("5935187621", "E123129751"));
    }
    
    public void logginfuction(Locale locale) {
        ResourceBundle rbundle = ResourceBundle.getBundle("ebank_new.message", locale);

//        ResourceBundle rbundle = ResourceBundle.getBundle("message", locale);
        while (true) {
            
            String username = Validation.getString(
                    rbundle.getString("accnumber"),
                    rbundle.getString("accnumberError"),
                    Validation.REGEX_STRING);
            
            String password;
            password = Validation.getString(
                    rbundle.getString("password"),
                    rbundle.getString("passwordError"),
                    Validation.REGEX_PASSWORD);
            
            Account acc = new Account(username, password);
            if (checkDulicate(acc)) {
                break;
            } else {
                System.out.println("Wrong name or password");
            }
        }
        
        while (true) {
            String captcha = generateCaptcha(new Random().nextInt(4)+6);  // sinh số ngẫu nhiên từ 0-3 có thể là 0123 nếu radom ra 0 thì captra dài 6 kí tự còn ra 3 thì captra dài 9 kí tự
            System.out.println(rbundle.getString("captcha")+ captcha);     // resource bunder dùng để lấy text theo ngôn ngữ // get string " captra dùng để lấy chuoxi trong ngôn ngữ
            String inputcaptcha = Validation.getString(rbundle.getString("captchainput"), 
                    rbundle.getString("captchaerror"), 
                    Validation.REGEX_CAPTCHA);
            
            if (checkcaptcha(captcha, inputcaptcha)) {
                System.out.println(rbundle.getString("Logginsucces"));
                break;
            } else {
                System.out.println(rbundle.getString("Logginfail"));   // thiếu chữ g
            }
        }
    }
    
    
    public String generateCaptcha(int length) {
    String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";   // thiếu ksi tự in hoa
    String numbers = "0123456789";
    String special = "!@#$%^&*";

    Random rd = new Random();
    StringBuilder sb = new StringBuilder();

    // đảm bảo có đủ
    sb.append(numbers.charAt(rd.nextInt(numbers.length())));
    sb.append(special.charAt(rd.nextInt(special.length())));
    sb.append(letters.charAt(rd.nextInt(letters.length())));

    String all = letters + numbers + special;

    for (int i = 3; i < length; i++) {
        sb.append(all.charAt(rd.nextInt(all.length())));
    }

    return sb.toString();
}
//    public String generateCaptcha(int lenght) {
//        
//        String chars = "1234567890"
//                + "qwertyuiopasdfghjklzxcvbnm"
//                + "QWERTYUIOPASDFGHJKLZXCVBNM";
//        
//        StringBuilder sb = new StringBuilder();
//        Random rd = new Random();
//        
//        for (int i = 0; i < lenght; i++) {
//            sb.append(chars.charAt(rd.nextInt(chars.length())));
//        }
//        
//        return sb.toString();
//    }
    // dùng boolean ở đây để xem acount có tồn tại không nếu dùng void thì người dùng không biết là có tồn tại không ví dụ có thfi trả về true và không có trả về false
    private boolean checkDulicate(Account acc) {
        for (Account account : listAcc) {
            if (account.getUsername().equals(acc.getUsername())
                    && account.getPassword().equals(acc.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkcaptcha(String captcha, String inputcaptcha) { 
        if (inputcaptcha == null || inputcaptcha.isEmpty()) {    
            return false;
        }
        return captcha.equals(inputcaptcha.trim());
    }
    
}
