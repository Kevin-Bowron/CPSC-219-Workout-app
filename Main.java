import java.io.IOException;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        ValidateUserLogIn.AccountInterface();
        AccessOldWorkouts.wantOldData();
        AppendWorkout appendWorkout = new AppendWorkout();
        AppendWorkout.appendToTodaysWorkout();
        AppendWorkout.appendTodaysWorkoutToFile();

    }
}