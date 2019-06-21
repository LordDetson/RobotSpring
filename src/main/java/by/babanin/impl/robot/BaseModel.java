package by.babanin.impl.robot;

import by.babanin.interfaces.Hand;
import by.babanin.interfaces.Head;
import by.babanin.interfaces.Leg;
import by.babanin.interfaces.Robot;

public abstract class BaseModel implements Robot {
    private Head head;
    private Hand hand;
    private Leg leg;

    public BaseModel() {
    }

    public BaseModel(Head head, Hand hand, Leg leg) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    public boolean haveHeadHandLeg() {
        return head != null && hand != null && leg != null;
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
