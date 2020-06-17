package sk.zrebec.learn.java.designpatterns.adapter;

/**
 * Adapter provides transformation from Kyocera printer driver methods to our interface methods
 * We need implements here all used methods in interface for full functionality.
 */
public class KyoceraPrinterAdapter implements IPrinterDriver {

    private final KyoceraPrinter kyocera;

    public KyoceraPrinterAdapter(KyoceraPrinter k) {
        kyocera = k;
    }

    @Override
    public void setName(String name) {
        kyocera.prinerModel(name);
    }

    @Override
    public void setPowerStat(boolean powerStat) {
        kyocera.electricSwitch(powerStat);
    }

    @Override
    public void setTonerStat(short tonerStat) {
        kyocera.cassetteFill(tonerStat);
    }

    @Override
    public void getPrinterStat() {
        kyocera.aboutPrinter();
    }
}
