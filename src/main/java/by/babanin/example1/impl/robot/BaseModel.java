package by.babanin.example1.impl.robot;

import by.babanin.example1.interfaces.Hand;
import by.babanin.example1.interfaces.Head;
import by.babanin.example1.interfaces.Leg;
import by.babanin.example1.interfaces.Robot;

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
