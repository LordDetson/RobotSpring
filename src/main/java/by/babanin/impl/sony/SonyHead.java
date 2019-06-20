package by.babanin.impl.sony;

import by.babanin.interfaces.Head;

import static by.babanin.Constant.*;

public class SonyHead implements Head {
    @Override
    public void calc() {
        System.out.printf(THINKING_ABOUT_FORMAT, SONY);
    }
}
