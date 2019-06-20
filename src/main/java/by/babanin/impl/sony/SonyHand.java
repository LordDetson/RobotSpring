package by.babanin.impl.sony;

import by.babanin.interfaces.Hand;

import static by.babanin.Constant.CATCHED_FROM_FORMAT;
import static by.babanin.Constant.SONY;

public class SonyHand implements Hand {
    @Override
    public void catchSomething() {
        System.out.printf(CATCHED_FROM_FORMAT, SONY);
    }
}
