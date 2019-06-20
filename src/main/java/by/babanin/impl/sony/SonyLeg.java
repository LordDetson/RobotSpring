package by.babanin.impl.sony;

import by.babanin.interfaces.Leg;

import static by.babanin.Constant.*;

public class SonyLeg implements Leg {
    @Override
    public void go() {
        System.out.printf(GO_TO_FORMAT, SONY);
    }
}
