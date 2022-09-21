package repository.LoginAccount;


public class loginAccount {

    public static String SignUp_Button = "(//a [@class='btn btn-signup'])";
    public static String Login_TextLink = "a[href='/login']";


    //verify Page Login
    public static String URLLogin_Expected = "https://dashboard.midtrans.com/login";
    public static String TitleLogin_Expected = "MAP | Midtrans";

    //Page Login
    public static String EmailAddress_Textbox = "(//input[@class='l-log '])";
    public static String Password_Textbox = "(//input[@class='l-log l-log-last '])";
    public static String LogMeIn_Button = "button[type='submit']";

    //Data Login
    public static String EmailValid = "rabbitha007@gmail.com";
    public static String PasswordValid = "Testing01";
    public static String PasswordInvalid = "testing01";

    //Alert Failed Login
    public static String TextAlert = ".l-wrong-password.l-wrong";
    public static String TextAlert_Expected = "Invalid email or password.";
    public static String Alert_EmailTextbox = "(//input[@class='l-log l-wrong'])";
    public static String Alert_PasswordTextbox = "(//input[@class='class=\"l-log l-log-last l-wrong\"'])";

    //Dashboard Page
    public static String closePopup_Button = "#onboard-passport-modal > div.tjr-modal > button";
    public static String URLDashboard_Expected = "https://dashboard.midtrans.com/";
    public static String user = "(//span[@class='tjr-global-nav__tab-label'])";
    public static String sidebar = "(//div[@class='tjr-app-shell__sidebar'])";

}
