package by.babanin.impl.toshiba;

import by.babanin.interfaces.Leg;

import static by.babanin.Constant.*;

public class ToshibaLeg implements Leg {
    @Override
    public void go() {
        System.out.printf(GO_TO_FORMAT, TOSHIBA);
    }
}
