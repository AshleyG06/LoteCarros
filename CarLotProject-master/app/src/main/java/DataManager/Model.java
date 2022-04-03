package DataManager;
import DataManager.Pool.*;

public class Model extends Component{
    private String modelName = new String();
    private int modelYear=0; 
    
    public void bindToBrand(Brand brandObj) throws ComponentNotBoundToPool{
        if(!BrandPool.get().componentIsRegisteredAtPool(brandObj)){
            throw new ComponentNotBoundToPool("The 'brand' object passed to bindToBrand does not exist inside BrandPool");
        }
        brandObj.addChild(this);
        
    }
    
    public Brand getBrand(){
        return (Brand)getParent();
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
    
}