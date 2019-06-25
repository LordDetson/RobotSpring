package by.babanin.example1.impl.sony;

import by.babanin.example1.interfaces.Head;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static by.babanin.example1.Constant.*;

@Component
@Lazy
@Qualifier("sony")
public class SonyHead implements Head {
    @Override
    public void calc() {
        System.out.printf(THINKING_ABOUT_FORMAT, SONY);
    }
}
