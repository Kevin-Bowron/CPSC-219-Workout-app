import java.io.*;
import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;


public class AppendWorkout {

    private static final String FILE_PATH = "src/WorkoutHistory.txt"; // Path to file storing all old data

    private static HashMap<String, WorkoutStats> workoutMap; // Library of all possible exercises
    private static int nextRowIndex = 0; // defined outside method so value exists outside of method

    static HashMap<String, WorkoutStats>[] todaysWorkout = new HashMap[4]; // Define an array of hash maps

    // Class constructor to initialize values of today's workout hash map and workoutMap hash map
    public AppendWorkout() {
        // Initialize each index of todaysWorkout
        for (int i = 0; i < 4; i++) {
            todaysWorkout[i] = new HashMap<>();
        }
        // Create instance of workoutMap hash map
        workoutMap = new HashMap<>();
        // initialize pull workouts
        workoutMap.put("Deadlift", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Lat pull down", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Barbell row", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Barbell Curl", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Close grip preacher curl", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Incline hammer curls", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Bent over rows", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Wide grip preacher curl", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Seated cable row", new WorkoutStats(0.0, 0.0));
        // initialize push workouts
        workoutMap.put("Bench Press", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Dumbbell Shoulder Press", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Triceps push downs", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Lateral Raises", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Incline Bench Press", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Standing Military Press", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Front Lateral Raises", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Skull Crushers", new WorkoutStats(0.0, 0.0));
        // initialize Leg workouts
        workoutMap.put("Squats", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Leg Press", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Leg extensions", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Leg curls", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Calf Raises", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Hack Squats", new WorkoutStats(0.0, 0.0));
        workoutMap.put("Bulgarian Split Squats", new WorkoutStats(0.0, 0.0));

    }


    /**
     * Calculates the average number of repetitions per set.
     *
     * @param RepsPSet an array representing the number of repetitions per set
     * @return the average number of repetitions per set
     */
    public static double calcAvgReps(double[] RepsPSet) {
        int TotalReps = 0;
        int TotalSets = RepsPSet.length - 1;

        for (int i = 0; i <= TotalSets; ++i) {
            TotalReps = (int) ((double) TotalReps + RepsPSet[i]);
        }

        return (double) TotalReps / (double) TotalSets;
    }

    /**
     * Calculates the average weight lifted per set.
     *
     * @param WeightPSet an array representing the weight lifted per set
     * @return the average weight lifted per set
     */
    public static double calcAvgWeight(double[] WeightPSet) {
        double TotalWeight = 0.0;
        int TotalSets = WeightPSet.length - 1;

        for (int i = 0; i <= TotalSets; ++i) {
            TotalWeight += WeightPSet[i];
        }

        return TotalWeight / (double) TotalSets;
    }


    public static void workoutReport(String exercise) {
        System.out.println(exercise);
        Scanner workout = new Scanner(System.in);
        // initialize new double arrays to contain reps and weight done for each exercise
        double[] workoutR = new double[3];
        double[] workoutW = new double[3];
        String initialInput;
        // loop through exercise for 3 sets
        for (int i = 0; i < 3; i++) {
            // errorLoops under for loop so for each set, while loops reset
            boolean errorLoopReps = false;
            boolean errorLoopWeight = false;
            // loop inside for loop, to check for errors and not alter for loop if wrong input is given
            while (!errorLoopReps) {
                System.out.println("Set " + (i + 1) + ":");
                System.out.println("reps:");
                initialInput = workout.nextLine();
                if (!InputCheck.validInput(initialInput)) {
                    System.out.println("input should only contain numbers");
                    continue;
                } else {
                    workoutR[i] = Double.parseDouble(initialInput);
                    errorLoopReps = true;
                }
            }
            while (!errorLoopWeight) {
                System.out.println("Weight:");
                initialInput = workout.nextLine();
                if (!InputCheck.validInput(initialInput)) {
                    System.out.println("input should only contain numbers");
                    continue;
                } else {
                    workoutW[i] = Double.parseDouble(initialInput);
                    errorLoopWeight = true;
                }
            }
        }
        double avgReps = calcAvgReps(workoutR);
        double avgWeight = calcAvgWeight(workoutW);
        // Create new instance of the custom workoutStats class with these avg values
        WorkoutStats workoutStats = new WorkoutStats(avgReps, avgWeight);
        // Append current exercise and instance of workoutStats into todaysWorkout
        todaysWorkout[nextRowIndex].put(exercise, workoutStats);
        // Increase this variable so next time method is called, the data is stored in the next available index
        nextRowIndex++;
    }

    public static void appendToTodaysWorkout() {
        // Static method to set new variable = to WorkoutLists return value
        String[] WorkoutSet = WorkoutSets.WorkoutLists();
        int length = WorkoutSet.length;
        // For each index of WorkoutSet, pass that value as parameter for workoutReport
        for (int i = 0; i < length; i++) {
            workoutReport(WorkoutSet[i]);
        }
    }


    public static void appendTodaysWorkoutToFile() throws FileNotFoundException {
        String workoutToAppend = null;
        boolean foundExercise = false;

        for (HashMap<String, WorkoutStats> currentIndex : todaysWorkout) {
            // Check if the current HashMap is not null
            if (currentIndex != null) {
                // Iterate over the entries of the HashMap at currentIndex
                for (Map.Entry<String, WorkoutStats> entry : currentIndex.entrySet()) {
                    workoutToAppend = entry.getKey();
                    WorkoutStats dataToAppend = entry.getValue();

                    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        // Read the file line by line until it reaches an empty line
                        while ((line = reader.readLine()) != null) {
                            // once the line reaches the correct exercise, set boolean to true
                            if (line.equals(workoutToAppend)) {
                                foundExercise = true;
                            }
                            // once boolean is true and line passes all old workout values being stored
                            if (foundExercise && line.equals("-")) {
                                // replace - with new workoutStats and then make a line to keep formatting with a -
                                content.append(dataToAppend).append("\n-\n");
                                foundExercise = false; // Reset boolean flag
                            } else {
                                // Append the line to the content
                                content.append(line).append("\n");
                            }
                        }

                        // Write the modified content back to the file
                        try (FileWriter writer = new FileWriter(FILE_PATH)) {
                            writer.write(content.toString());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}