public class InputCheck {

    /*
     * This method is an error checker for any input that should be a double
     * @param The input in the type String, so the error checker can parse it to check validity
     * @return boolean if input is valid
     */
    public static boolean validInput(String check) {
        try {
            Double.parseDouble(check);
            return true; // Input can be parsed to a double
        } catch (NumberFormatException e) {
            return false; // Input cannot be parsed to a double
        }
    }

    /*
     * This method is an error checker used in WorkoutSets, that makes sure input is an int and either 1,2 or 3
     * @param The input in the type String, so the error checker can parse it to check validity
     * @return boolean if input is valid
     */
    public static boolean validMenuInput(String check){
        try {
            int userIntInput = Integer.parseInt(check);
             return userIntInput >= 1 && userIntInput <= 3;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
     * This method is an error checker for any input that should be an int and either 1 or 2
     * @param The input in the type String, so the error checker can parse it to check validity
     * @return boolean if input is valid
     */
    public static boolean validLoginInput(String check){
        try {
            int userIntInput = Integer.parseInt(check);
            return userIntInput >= 1 && userIntInput <= 2;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}


