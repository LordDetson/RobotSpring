package by.babanin.impl.sony;

import by.babanin.interfaces.Hand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static by.babanin.Constant.CATCHED_FROM_FORMAT;
import static by.babanin.Constant.SONY;

@Component
@Lazy
@Qualifier("sony")
public class SonyHand implements Hand {
    @Override
    public void catchSomething() {
        System.out.printf(CATCHED_FROM_FORMAT, SONY);
    }
}
