package sk.zrebec.learn.java.designpatterns.adapter;

/**
 * This is common interface used in our application to control any printer.
 * The methods are equals to Samsung printer class methods because this brand is most used in our company
 */
public interface IPrinterDriver {

    /**
     * Set the printer model name (unfortunately, here is is called name instead of model)
     *
     * @param name model of printer
     */
    void setName(String name);

    /**
     * Set boolean method if printer is in or off
     *
     * @param powerStat boolean power switch
     */
    void setPowerStat(boolean powerStat);

    /**
     * let printer stat to stdout
     */
    void getPrinterStat();

    /**
     * How much is filled the printer with toner
     *
     * @param tonerStat percentage if toner filament
     */
    void setTonerStat(short tonerStat);

}
