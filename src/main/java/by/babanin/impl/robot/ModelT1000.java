package by.babanin.impl.robot;

import by.babanin.Constant;
import by.babanin.interfaces.Hand;
import by.babanin.interfaces.Head;
import by.babanin.interfaces.Leg;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.StringJoiner;

public class ModelT1000 extends BaseModel implements InitializingBean, DisposableBean {
    private String name;
    private String color;
    private int year;
    private boolean soundEnabled;

    public ModelT1000() {
    }

    public ModelT1000(Head head, Hand hand, Leg leg) {
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
        if (haveHeadHandLeg()) {
            getHead().calc();
            getHand().catchSomething();
            getLeg().go();
        }
    }

    @Override
    public void dance() {
        System.out.printf(Constant.IS_DANCE_FORMAT, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

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
