package DataManager;
import java.lang.Exception;

public class ComponentNotBoundToPool extends Exception{
    public ComponentNotBoundToPool(String message){
        super(message);
    }
}