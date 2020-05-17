package DesignPatterns;

public class PhoneCharge implements Adapter {


    ChargerAdapter ca = new ChargerAdapter();
    public void doCharge() {
        ca.charge();
    }

    @Override
    public void adaptCharge() {
        ca.charge();
    }

    public static void main (String[] args) {
        PhoneCharge pc = new PhoneCharge();

        pc.doCharge();
        }
    }

