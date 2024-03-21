import java.util.Arrays;
import java.util.Scanner;

public class WorkoutSets {

    // Different workout sets
    public static final String[] pull1 = {"Deadlift", "Lat pulldown", "Barbell row", "Barbell Curl"};
    public static final String[] pull2 = {"Close grip preacher curl", "Incline hammer curls", "Lat pull down", "Bent over rows"};
    public static final String[] pull3 = {"Wide grip preacher curl", "Seated cable row", "Barbell Curl", "Deadlift"};

    public static final String[] leg1 = {"Squats", "Leg Press", "Leg extensions", "Leg curls"};
    public static final String[] leg2 = {"Leg press", "Leg curls", "Calf Raises", "Leg Extensions"};
    public static final String[] leg3 = {"Hack Squats", "Bulgarian Split Squats", "Leg Curls", "Calf Raises"};

    public static final String[] push1 = {"Bench Press", "Dumbbell Shoulder Press", "Triceps push downs", "Lateral Raises"};
    public static final String[] push2 = {"Incline Bench Press", "Standing military Press", "Triceps Push downs", "Front lat Raises"};
    public static final String[] push3 = {"Lateral Raises", "Bench press", "Skull Crushers", "Dumbbell shoulder press"};

    /*
     * This method asks what type of workout day it i
     * @returns a string array of length 4, that contains today's workout set
     */
    public static String menu() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Choose today's workout day: ");
        System.out.println("1. Push day");
        System.out.println("2. Pull day");
        System.out.println("3. Leg day");
        input = scanner.nextLine();
        return input;
    }

    /*
     * This method specifies the exact workout they will do
     * @return the sum of a and b
     */
    public static String[] WorkoutLists() {
        String WorkoutS;
        int Workout = 0;
        // Loop through running the menu method until input is correct
        while (true) {
            WorkoutS = menu();
            if (InputCheck.validMenuInput(WorkoutS)) {
                Workout = Integer.parseInt(WorkoutS);
                break;
            } else {
                System.out.println("Ensure your input is valid");
                continue;
            }
        }
        // variable as String so input checking can try to parse it into an int to ensure its valid
        String workoutNumS;
        // Input will be converted to Int once input is correct
        int workoutNumI;
        // List that will be returned as that days workout set
        String[] WorkoutChoice = new String[4];
        while (true) {
            Scanner scanner = new Scanner(System.in);
            // if they choose push day
            if (Workout == 1) {
                // let them choose 1 of 3 push day workout sets
                System.out.println("Choose which workout set you want to do today:");
                System.out.println("1. " + Arrays.toString(push1));
                System.out.println("2. " + Arrays.toString(push2));
                System.out.println("3. " + Arrays.toString(push3));
                workoutNumS = scanner.nextLine();
                // Check valid input
                if (!InputCheck.validMenuInput(workoutNumS)) {
                    System.out.println("Ensure you provide correct input");
                    continue;
                } else {
                    workoutNumI = Integer.parseInt(workoutNumS);
                    WorkoutChoice = switch (workoutNumI) {
                        case 1 -> push1;
                        case 2 -> push2;
                        case 3 -> push3;
                        default -> WorkoutChoice;
                    };
                    break;
                }
            } else if (Workout == 2) {
                // let them choose 1 of 3 pull day workout sets
                System.out.println("Choose which workout set you want to do today:");
                System.out.println("1. " + Arrays.toString(pull1));
                System.out.println("2. " + Arrays.toString(pull2));
                System.out.println("3. " + Arrays.toString(pull3));
                workoutNumS = scanner.nextLine();
                // Check valid input
                if (!InputCheck.validMenuInput(workoutNumS)) {
                    System.out.println("Ensure you provide correct input");
                    continue;
                } else {
                    workoutNumI = Integer.parseInt(workoutNumS);
                    WorkoutChoice = switch (workoutNumI) {
                        case 1 -> pull1;
                        case 2 -> pull2;
                        case 3 -> pull3;
                        default -> WorkoutChoice;
                    };
                    break;
                }
            } else if (Workout == 3) {
                // let them choose 1 of 3 leg day workout sets
                System.out.println("Choose which workout set you want to do today:");
                System.out.println("1. " + Arrays.toString(leg1));
                System.out.println("2. " + Arrays.toString(leg2));
                System.out.println("3. " + Arrays.toString(leg3));
                workoutNumS = scanner.nextLine();
                // Check valid input
                if (!InputCheck.validMenuInput(workoutNumS)) {
                    System.out.println("Ensure you provide correct input");
                    continue;
                } else {
                    workoutNumI = Integer.parseInt(workoutNumS);
                    WorkoutChoice = switch (workoutNumI) {
                        case 1 -> leg1;
                        case 2 -> leg2;
                        case 3 -> leg3;
                        default -> WorkoutChoice;
                    };
                    break;
                }
            }
        }
        return WorkoutChoice;
    }


}
