package SystemDesign.LLD.DesignPattern.c_Behavioral.c_State.State;

import SystemDesign.LLD.DesignPattern.c_Behavioral.c_State.*;

public class DispenseState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Please wait, dispensing");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("Please wait, dispensing");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Dispensed product");
        machine.setState(new NoCoinState());
    }
}