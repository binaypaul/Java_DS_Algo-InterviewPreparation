package SystemDesign.LLD.DesignPattern.c_Behavioral.c_State.State;

import SystemDesign.LLD.DesignPattern.c_Behavioral.c_State.*;

public class NoCoinState implements VendingMachineState{
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin inserted");
        machine.setState(new HasCoinState());
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("Insert coin first");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Insert coin first");
    }
}
