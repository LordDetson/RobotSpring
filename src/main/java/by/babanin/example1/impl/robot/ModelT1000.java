package by.babanin.example1.impl.robot;

import by.babanin.example1.Constant;
import by.babanin.example1.interfaces.Hand;
import by.babanin.example1.interfaces.Head;
import by.babanin.example1.interfaces.Leg;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
@Lazy
public class ModelT1000 extends BaseModel implements InitializingBean, DisposableBean {
    private String name;
    private String color;
    private int year;
    private boolean soundEnabled;

    public ModelT1000() {
    }

    @Autowired
    public ModelT1000(
            @Qualifier("toshiba")Head head,
            @Qualifier("toshiba")Hand hand,
            @Qualifier("toshiba")Leg leg
    ) {
        super(head, hand, leg);
    }

    public ModelT1000(String name, Head head, Hand hand, Leg leg) {
        super(head, hand, leg);
        this.name = name;
    }

    public ModelT1000(String name, Head head, Hand hand, Leg leg, String color, int year, boolean soundEnabled) {
        super(head, hand, leg);
        this.name = name;
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    public ModelT1000(String name, String color, int year, boolean soundEnabled) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    @Override

    public void action() {
        System.out.println("name: " + this.getName());
        if (haveHeadHandLeg()) {
            getHead().calc();
            getHand().catchSomething();
            getLeg().go();
        }
        System.out.println("color: " + this.getColor());
        System.out.println("year: " + this.getYear());
        System.out.println("soundEnabled: " + this.isSoundEnabled());
    }

    @Override
    public void dance() {
        System.out.printf(Constant.IS_DANCE_FORMAT, name);
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", ModelT1000.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("head=" + getHead().getClass().getSimpleName())
                .add("hand=" + getHand().getClass().getSimpleName())
                .add("leg=" + getLeg().getClass().getSimpleName())
                .add("color='" + color + "'")
                .add("year=" + year)
                .add("soundEnabled=" + soundEnabled)
                .toString();
    }

    @Override
    public void destroy() throws Exception {
        System.out.printf("%s - method destroy()\n", name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.printf("%s - method init()\n", name);
    }
}
