import java.io.*;
import java.util.Scanner;

public class ValidateUserLogIn {
    private static final String LoginFilePath = "src/login.txt";

    public static void AccountInterface() throws IOException {
        boolean LogOrSign = LogInOrSignUp();
        if (LogOrSign){
            // Run until Login is correct
            while (true) {
                // true if login is correct
                boolean CorrectInfo = logIn();
                if (CorrectInfo) {
                    System.out.println("Login succesfull");
                    break;
                } else {
                    System.out.println("Login details are incorrect");
                    continue;
                }
            }

        }
        else{
            signUp();
        }

    }

    public static boolean LogInOrSignUp() {
        Scanner scanner = new Scanner(System.in);
        // Initialize as String for error checking
        String LogOrSign;
        // Ask them this until they input either 1 or 2
        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            LogOrSign = scanner.nextLine();
            if (InputCheck.validLoginInput(LogOrSign)) {
                break;
            } else {
                System.out.println("type 1 to log in, type 2 to Sign up");
                continue;
            }
        }
        boolean Check;
        // parse choice into int
        int LogSign = Integer.parseInt(LogOrSign);
        Check = LogSign == 1;
        // Returns true if they choose to log in
        return Check;
    }


    public static void signUp() throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LoginFilePath, true))) {
            System.out.print("Create a Username:");
            String Username = scanner.nextLine();
            System.out.println("Create a password");
            String Password = scanner.next();
            // append username and password to txt file to save login information
            writer.write(Username + "," + Password);
            writer.newLine();
            }catch (IOException e) {
                e.printStackTrace(); // Handle file IO errors just encase
            }
        }

    public static boolean logIn(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Username:");
    String Username = scanner.nextLine();
    System.out.println("Enter Password:");
    String Password = scanner.nextLine();
    //boolean return from method that compares the username and password they provide to the one they set
    return CheckLogInCredentials(Username, Password);
    }



    public static boolean CheckLogInCredentials(String Username, String Password)  {
        try (Scanner scanner = new Scanner(new File(LoginFilePath))) {
            String[] Info = new String[2];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Info = line.split(",");
                System.out.println(Info[0]);

            }
            if (Info[0].equals(Username) && Info[1].equals(Password)) {
                return true; // case where username and password matches that found in the txt file
            } else {
                return false;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }















}
