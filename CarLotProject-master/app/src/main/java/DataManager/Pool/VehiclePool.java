package DataManager.Pool;

public class VehiclePool extends ComponentPool{
    private static VehiclePool instance = new VehiclePool();
    public static VehiclePool get(){
        return instance;
    }
}
