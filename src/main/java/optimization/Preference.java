package optimization;

public interface Preference {

    void workEarlier(int amountOfEmployeeForOptimization, int changeTime, double efficiency, String resultChoice);
    void workLater(int amountOfEmployeeForOptimization, int changeTime, double efficiency, String resultChoice);
    void workInOldConditions();
    void workRemotely(int amountOfEmployeeForOptimization,double efficiency, String resultChoice);

}
