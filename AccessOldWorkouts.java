import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AccessOldWorkouts {
    private static final String FILE_PATH = "src/WorkoutHistory.txt"; // Path to file storing all old data


    public static void wantOldData() {
        Scanner scanner = new Scanner(System.in);
        String input;
        int input1;
        while (true) {
            System.out.println("Would you Like to View your previous workoutLogs?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            input = scanner.nextLine();
            if (InputCheck.validLoginInput(input)) {
                input1 = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Must enter 1 or 2");
                continue;
            }
        }
        if (input1 == 1) {
            System.out.println("input the exercise you want to review");
            input = scanner.nextLine();
            ReadFromFile(input);
        }


    }



    public static void ReadFromFile(String exercise) {
        boolean foundExercise = false;
        String[] retrieveNumbers = new String[2];
        String line;
        // ArrayList so however many values are stored can be accessed
        List<String> allOldData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            // Read the file line by line until it reaches an empty line
            while ((line = reader.readLine()) != null) {
                if (foundExercise){
                    if (line.equals("-")){
                        foundExercise = false;
                        break;
                    }
                    retrieveNumbers = line.split(",");
                    allOldData.add(Arrays.toString(retrieveNumbers));
                }
                // Once Line reaches the desired exercise, set boolean flag to true
                if (line.equals(exercise)) {
                    foundExercise = true;
                }

            }
            System.out.println(allOldData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }








}
