package SystemDesign.LLD.DesignPattern.c_Behavioral.c_State;

import DataStructure.Neetcode150.P_2D_DP.*;

public class Usage {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        machine.dispenseProduct();  // "Insert coin first"
        machine.selectProduct();    // "Insert coin first"

        System.out.println();

        machine.insertCoin();       // "Coin inserted"
        machine.selectProduct();    // "Product selected"
        machine.dispenseProduct();  // "Dispensing product"

    }
}
