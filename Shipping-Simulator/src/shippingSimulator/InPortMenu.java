/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shippingSimulator;

/**
 *
 * @author benja
 */
public class InPortMenu {

    private final String[] inPortMenu = {"Depart for the next port", "Load Containers", "Speak with Harbormaster", "Retire"};

    public InPortMenu() {
    }

    public void inPortDecisionParser(PlayerShip ps) {
        int menuDecision = Abstract.userStringToInt();
        if (menuDecision == 1) {
            Iteration it = new Iteration();
            it.mainGameIteration(ps);
        }
        if (menuDecision == 2) {
            Iteration it = new Iteration();
            it.containerLoaderIteration(ps);
        }
        if (menuDecision == 3) {
            Iteration it = new Iteration();
            it.harborMasterItration(ps);
        }
        if (menuDecision == 4) {
            System.out.println("Thank you for playing.");
            System.exit(0);
        }
    }

    public void inPortMenuBlock(PlayerShip ps) {
        // inPortPrimaryMenu();
        Abstract.standardGameMenu(inPortMenu);
        inPortDecisionParser(ps);
    }

}
