package SystemDesign.LLD.DesignPattern.c_Behavioral.c_State.State;

import SystemDesign.LLD.DesignPattern.c_Behavioral.c_State.*;

public interface VendingMachineState {
    void insertCoin(VendingMachine machine);
    void selectProduct(VendingMachine machine);
    void dispense(VendingMachine machine);
}
