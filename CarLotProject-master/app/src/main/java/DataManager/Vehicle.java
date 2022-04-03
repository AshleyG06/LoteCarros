package DataManager;
import DataManager.Pool.*;

public class Vehicle extends Component{
    //TODO: Add fields and get/set methods
    private String vehicleName = new String();
    private Boolean quemacocos = false;
    private Integer numPuertas = 0;
    private Integer asientos = 0;
    private Double kilometraje = 0.0;
    private Double gasolina = 0.0;
    
    public void bindToModel(Model modelObj) throws ComponentNotBoundToPool{
        if(!ModelPool.get().componentIsRegisteredAtPool(modelObj)){
            throw new ComponentNotBoundToPool("The 'model' object passed to bindToModel does not exist inside ModelPool");
        }
        modelObj.addChild(this);
    }
    
    public Model getModel(){
        return (Model)getParent();
    }

    public String getVehicleName(){
        return this.vehicleName;
    }
    
    public void setVehicleName(String name){
        this.vehicleName = name;
    }

    public Boolean getQuemacocos(){
        return this.quemacocos;
    }

    public void setQuemacocos(Boolean cocos){
        this.quemacocos = cocos;
    }

    public Integer getNumPuertas(){
        return numPuertas;
    }

    public void setNumPuertas(Integer puertas){
        this.numPuertas = puertas;
    }

    public Integer getAsientos(){
        return asientos;
    }

    public void setAsientos(Integer asientos){
        this.asientos = asientos;
    }

    public Double getKilometraje(){
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje){
        this.kilometraje = kilometraje;
    }

    public Double getGasolina(){
        return gasolina;
    }

    public void setGasolina(Double gasolina){
        this.gasolina = gasolina;
    }
}