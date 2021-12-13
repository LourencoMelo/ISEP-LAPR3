package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class ShipChiefElectricalEngineerUI implements Runnable {

    public ShipChiefElectricalEngineerUI(){

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        try{
            List<MenuItem> options = new ArrayList<>();


            options.add(new MenuItem("Get what set of materials to use in a container, to operate at temperatures of 7°C", new GetSetOfMaterialsToContainerAtSevenUI()));

            int option = 0;

            do{
                option = Utils.showAndSelectIndex(options, "\n\n\t\t\t\t\t\t\t\t======================== Ship Chief Electrical Engineer Menu ========================\n\n");

                if ((option >= 0) && (option < options.size())){
                    options.get(option).run();
                }
            }while (option != -1);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
