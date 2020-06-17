package sk.zrebec.learn.java.designpatterns.adapter;

/**
 * This is driver from different printers supplier. If we want use our common interface (clients wants using
 * methods like in Samsung printers), after load this driver, we must create an adapter.
 * <p>
 * This is mostly cheapest solution if you don't want have big login in you base application login (in this case the
 * logic is in Program.java) and u can use same methods for any else printer manufacturer.
 */

public class KyoceraPrinter {

    private String printerModel;
    private boolean electricSwitch = false;
    private int cassetteFill;

    public void prinerModel(String printerName) {
        this.printerModel = printerName;
    }

    public void electricSwitch(boolean electricSwitch) {
        this.electricSwitch = electricSwitch;
    }

    public void cassetteFill(int cassetteFill) {
        this.cassetteFill = cassetteFill;
    }

    public void aboutPrinter() {
        System.out.println("This Kyocera printer is called " + printerModel + ", electric switch is " + (electricSwitch ? "enabled" : "disabled") + " cassette has " +
                cassetteFill + "% filament");
    }

}
