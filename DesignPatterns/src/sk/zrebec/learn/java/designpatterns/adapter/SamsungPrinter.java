package sk.zrebec.learn.java.designpatterns.adapter;

public class SamsungPrinter implements IPrinterDriver {

    private String name;
    private boolean powerStat = false;
    private int tonerStat;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPowerStat(boolean powerStat) {
        this.powerStat = powerStat;
    }

    @Override
    public void setTonerStat(short tonerStat) {
        this.tonerStat = tonerStat;
    }

    @Override
    public void getPrinterStat() {
        System.out.println("Your printer is called " + name + ", is powered " + (powerStat ? "on" : "off") + " and toner is filled to " +
                tonerStat + "%");
    }
}
