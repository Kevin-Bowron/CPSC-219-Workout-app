public class WorkoutStats {
    private double avgReps;
    private double avgWeight;

    /**
     * Constructs a WorkoutStats object that will contain both avg reps and avg weight
     * @param avgReps   type double
     * @param avgWeight type double
     */
    public WorkoutStats(double avgReps, double avgWeight){
        this.avgReps = avgReps;
        this.avgWeight = avgWeight;
    }


    /**
     * Returns a string representation of this WorkoutStats object, so it prints properly
     * Override used so this subclass will override its superclass
     * @return formatting on how avg reps and avg weight will be stored
     */
    @Override
    public String toString() {
        return   avgReps + "," + avgWeight;
    }
}
