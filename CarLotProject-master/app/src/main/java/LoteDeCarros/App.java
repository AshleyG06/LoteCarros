/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package LoteDeCarros;
import DataManager.*;
import DataManager.Pool.*;
import java.util.Scanner;

import com.google.errorprone.annotations.Var;


public class App {
    public static void main(String[] args) {
        try{

            // //Demostracion altas
            // Brand marca = new Brand();
            // marca.setBrandName("BMW");
            // BrandPool.get().registerComponent(marca);
            
            // Model modeloSport = new Model();
            // modeloSport.setModelName("300-I");
            // modeloSport.bindToBrand(marca);
            // ModelPool.get().registerComponent(modeloSport);

            // Model modeloCasual = new Model();
            // modeloCasual .setModelName("X5");
            // modeloCasual.bindToBrand(marca);
            // ModelPool.get().registerComponent(modeloCasual);

            // Vehicle carro1 = new Vehicle();
            // carro1.bindToModel(modeloCasual);
            // carro1.setVehicleName("Carro Honda");
            // carro1.setQuemacocos(false);
            // carro1.setNumPuertas(4);
            // carro1.setAsientos(5);
            // carro1.setGasolina(20.5);
            // carro1.setKilometraje(341.78);
            // VehiclePool.get().registerComponent(carro1);
            Scanner sc=new Scanner(System.in);

            System.out.println("Bienvenido al lote de autos");
            System.out.println("Para dar de alta un auto ingrese 1 de lo contrario ingrese 0")
            int alta=sc.nextInt();

            if(alta==1){

                System.out.println("Ingresa la marca del vehiculo");
                Brand marca = new Brand();
                marca.setBrandName(sc.nextLine());
                 BrandPool.get().registerComponent(marca);
            
                 System.out.println("Ingresa el modelo del vehiculo");
                 Model modeloSport = new Model();
                modeloSport.setModelName(sc.nextLine());
                 modeloSport.bindToBrand(marca);
                ModelPool.get().registerComponent(modeloSport);

                System.out.println("Ingresa nombre del vehiculo");
                Vehicle carro1 = new Vehicle();
                carro1.bindToModel(modeloSport);
                carro1.setVehicleName(sc.nextLine());
                System.out.println("Tiene quemacocos?");
                carro1.setQuemacocos(sc.nextBoolean());
                System.out.println("Ingrese el numero de puertas");
                carro1.setNumPuertas(sc.nextInt());
                System.out.println("Ingrese el numero de asientos");
                carro1.setAsientos(sc.nextInt());
                System.out.println("Ingrese la capacidad del tanque de gasolina");
                carro1.setGasolina(sc.nextDouble());
                System.out.println("Ingrese el kilometraje del auto");
                carro1.setKilometraje(sc.nextDouble());
                VehiclePool.get().registerComponent(carro1);
            }
            else if(alta==0){
                for(int i=0;i<BrandPool.get().countRegisterdComponents();i++){
                    System.out.println(BrandPool.get().getComponentAt(i));
                }
                System.out.println("Ingresa el nombre del vehiculo a dar de baja");
                String baja=sc.nextLine();

                for(int i=0;i<BrandPool.get().countRegisterdComponents();i++){
                    Var currentBrand=(Brand)BrandPool.get().getComponentAt(i);
                    
                    if(currentBrand.getBrandName().equals(baja)){
                        BrandPool.get().unregisterComponent(currentBrand);
                    }
                }
            }

            System.out.println("Elementos totales(Alta): " + BrandPool.get().getComponentAt(0).countChildrenRecurively());

            //Demostracion Cambios
            System.out.println("Nombre del modelo de carro antes de actualizar: " + carro1.getModel().getModelName());
            Model modeloSus = new Model();
            modeloSus.setModelName("AmongusCar");
            ModelPool.get().updateComponent(modeloCasual, modeloSus);
            System.out.println("Nombre del modelo de carro despues de actualizar: " + carro1.getModel().getModelName());
            System.out.println("Elementos totales(Cambios): " + BrandPool.get().getComponentAt(0).countChildrenRecurively());
            
            //Demostracion Bajas Individuales: Eliminar el modelo "Sport"(sin hijos)
            ModelPool.get().unregisterComponent(modeloSport);
            System.out.println("Elementos totales(Baja Individual): " + BrandPool.get().getComponentAt(0).countChildrenRecurively());

            //Demostracion Bajas en cascada: Buscar marca con nombre "BMW" y borrarla
            for(int i = 0; i < BrandPool.get().countRegisterdComponents(); i++){
                var currentBrand = (Brand)BrandPool.get().getComponentAt(i);
                if(currentBrand.getBrandName().equals("BMW")) {
                    BrandPool.get().unregisterComponent(currentBrand);
                }
            }
            System.out.println("Elementos en piscina de datos despues de baja en cascada");
            System.out.println("Cantidad de elementos en BrandPool: " + BrandPool.get().countRegisterdComponents());
            System.out.println("Cantidad de elementos en ModelPool: " + ModelPool.get().countRegisterdComponents());
            System.out.println("Cantidad de elementos en VehiclePool: " + VehiclePool.get().countRegisterdComponents());

            //Caracteristicas del vehiculo
            System.out.println("Caracteristicas de Carro 1");
            System.out.println("Carro 1 Nombre: " + carro1.getVehicleName());
            System.out.println("Carro 1 Asiento: " + carro1.getAsientos());
            System.out.println("Carro 1 Quemacocos: " + carro1.getQuemacocos());
            System.out.println("Carro 1 Puertas: " + carro1.getNumPuertas());
            System.out.println("Carro 1 Gasolina: " + carro1.getGasolina());
            System.out.println("Carro 1 Kilometraje: " + carro1.getKilometraje());


            Vehicle carro1 = new Vehicle();
            carro1.bindToModel(modeloCasual);
            carro1.setVehicleName("Carro Honda");
            carro1.setQuemacocos(false);
            carro1.setNumPuertas(4);
            carro1.setAsientos(5);
            carro1.setGasolina(20.5);
            carro1.setKilometraje(341.78);
            VehiclePool.get().registerComponent(carro1);
            }

           





        }catch(ComponentNotBoundToPool ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
