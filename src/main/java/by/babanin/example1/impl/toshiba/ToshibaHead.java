package by.babanin.example1.impl.toshiba;

import by.babanin.example1.interfaces.Head;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static by.babanin.example1.Constant.*;

@Component
@Lazy
@Qualifier("toshiba")
public class ToshibaHead implements Head {
    @Override
    public void calc() {
        System.out.printf(THINKING_ABOUT_FORMAT, TOSHIBA);
    }
}
