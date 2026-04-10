package SystemDesign.LLD.DesignPattern.c_Behavioral.c_State;

import SystemDesign.LLD.DesignPattern.c_Behavioral.c_State.State.*;

public class VendingMachine {

    private VendingMachineState currentState;


    public VendingMachine() {
        this.currentState = new NoCoinState();
    }

    public void insertCoin() {
        this.currentState.insertCoin(this);
    }

    public void selectProduct() {
        this.currentState.selectProduct(this);
    }

    public void dispenseProduct() {
        this.currentState.dispense(this);
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }
}
