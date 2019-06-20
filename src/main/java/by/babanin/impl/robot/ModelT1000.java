package by.babanin.impl.robot;

import by.babanin.Constant;
import by.babanin.interfaces.Hand;
import by.babanin.interfaces.Head;
import by.babanin.interfaces.Leg;
import by.babanin.interfaces.Robot;

public class ModelT1000 implements Robot {
    private Head head;
    private Hand hand;
    private Leg leg;

    public ModelT1000() {
    }

    public ModelT1000(Head head, Hand hand, Leg leg) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    @Override
    public void action() {
        head.calc();
        hand.catchSomething();
        leg.go();
    }

    @Override
    public void dance() {
        System.out.printf(Constant.IS_DANCE_FORMAT, getClass().getSimpleName());
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }
}
