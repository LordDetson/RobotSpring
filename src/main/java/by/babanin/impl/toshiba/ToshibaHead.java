package by.babanin.impl.toshiba;

import by.babanin.interfaces.Head;

import static by.babanin.Constant.*;

public class ToshibaHead implements Head {
    @Override
    public void calc() {
        System.out.printf(THINKING_ABOUT_FORMAT, TOSHIBA);
    }
}
