package sk.zrebec.learn.java.designpatterns.adapter;

/**
 * This is sample implementation of Adapter (also called Wapper or Translator) design pattern. Adapter design pattern is
 * one of the structural design patterns which allows 2 incompatible interfaces to work together.
 * <p>
 * For example in our company we are using a "Samsung" printers. But not we need implements "Kyocera" driver
 * which has different classes and functionality.
 * <p>
 * Class to "translate" methods is called adapter and class using different interface that our target is called
 * adaptee
 * <p>
 * -----------      -------------------------
 * | CLIENT |   ->  | methodA() from target |
 * -----------     --------------------------
 * ^
 * --------------------------      --------------------------
 * | methodA() from adapter |  <-  | methodB() from adptee  |
 * --------------------------      --------------------------
 */
public class Program {
    public static void main(String[] args) {

        // At first we create a Samsung printer
        IPrinterDriver c430w = new SamsungPrinter();
        c430w.setName("c430w");
        c430w.setTonerStat((short) 74);
        c430w.getPrinterStat();

        // Now we use the Adapter control drivers via our IPrinterDriver interface methods
        IPrinterDriver kyoceraAdapter = new KyoceraPrinterAdapter(new KyoceraPrinter());
        kyoceraAdapter.setName("P5021cdn");
        kyoceraAdapter.setPowerStat(true);
        kyoceraAdapter.setTonerStat((short) 96);
        kyoceraAdapter.getPrinterStat();

    }
}
