package repository.RegistrationAccount;

public class registrationAccount {

    public static String SignUp_Button = "(//a [@class='btn btn-signup'])";

    //Registration Page
    public static String RegistrationPage_Expected = "https://dashboard.midtrans.com/register";
    public static String BusinessName_TextBox = "#user_merchant_name";
    public static String FullName_TextBox = "#user_full_name";
    public static String BusinessEmail_TextBox = "#user_email";
    public static String BusinessPhoneNumber_Textbox = "#user_phone";
    public static String Password_Textbox = "#user_password";
    public static String ConfirmPassword_TextBox = "#user_password_confirmation";
    public static String Register_Button = "#signup_btn";

    //Registration Personal Data
    public static String BusinessName = "Pillow Soft Yello";
    public static String FullName = "Pillow Company";
    public static String BusinessEmail = "bisnis100@testing.com";
    public static String BusinessPhoneNumber = "857456123001";
    public static String Password = "IniCobaDulu01" ;
    public static String ConfirmPassword = "IniCobaDulu01";

    //Success Create Account
    public static String URLSuccess_Expected = "https://dashboard.midtrans.com/login?complete=1";
    public static String SuccesAlert_Box = "(//div[@class='f-h-sub l-success'])";

    //Failed Registration
    public static String BusinessName_alert = "(//div[@class='l-wrong-field l-wrong'])[1]";
    public static String FullName_alert = "(//div[@class='l-wrong-field l-wrong'])[2]";
    public static String BusinessEmail_alert = "(//div[@class='l-wrong-field l-wrong'])[3]";
    public static String BusinessPhoneNumber_alert = "(//div[@class='l-wrong-field l-wrong'])[4]";
    public static String Password_alert = "(//div[@class='l-wrong-field l-wrong'])[5]";
    public static String ConfirmPassword_alert = "(//div[@class='l-wrong-field l-wrong'])[6]";

    public static String BusinessName_Expected = "Merchant name can't be blank";
    public static String FullName_Expected = "Full name can't be blank";
    public static String BusinessEmail_Expected = "Email can't be blank";
    public static String BusinessPhoneNumber_Expected = "Phone can't be blank";
    public static String Password_Expected = "Password can't be blank";
    public static String ConfirmPassword_Expected = "Password confirmation can't be blank";
}