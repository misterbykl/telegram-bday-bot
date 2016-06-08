package bday;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author misterbykl
 * @since 1.0.0
 */
public class DGList {

    public static List<String> kisiListesi = null;
    public static Map<String, String> dgListesi = null;
    public static Map<String, String> dgtListesi = null;
    public static DateTimeFormatter dateFormat = null;

    /**
     * @param argKisiList
     * @param argDgList
     * @param argDgtList
     *
     * @author misterbykl
     * @since 1.0.0
     */
    public static void setDates(List<String> argKisiList, List<String> argDgList, List<String> argDgtList) {
        kisiListesi = argKisiList;
        dgListesi = new HashMap<>();
        dgtListesi = new HashMap<>();

        for (int i = 0; i < argKisiList.size(); i++) {

            dgListesi.put(argKisiList.get(i), argDgList.get(i));
            dgtListesi.put(argKisiList.get(i), argDgtList.get(i));
        }

    }

    /**
     * @author misterbykl
     *
     * @since 1.0.0
     */
    public static void setDateFormat() {
        dateFormat = DateTimeFormat.forPattern("d-M");
    }

    /**
     * @return
     * @author misterbykl
     *
     * @since 1.0.0
     */
    public static Map<String, String> getDgListesi() {
        return dgListesi;
    }

    /**
     * @param argDgListesi
     *
     * @author misterbykl
     * @since 1.0.0
     */
    public static void setDgListesi(Map<String, String> argDgListesi) {
        DGList.dgListesi = argDgListesi;
    }

    /**
     * @return
     *
     * @author misterbykl
     * @since 1.0.0
     */
    public static Map<String, String> getDgtListesi() {
        return dgtListesi;
    }

    /**
     * @param argDgtListesi
     *
     * @author misterbykl
     * @since 1.0.0
     */
    public static void setDgtListesi(Map<String, String> argDgtListesi) {
        DGList.dgtListesi = argDgtListesi;
    }

    /**
     * @return
     * @author misterbykl
     *
     * @since 1.0.0
     */
    public static List<String> getKisiListesi() {
        return kisiListesi;
    }

    /**
     * @param argKisiListesi
     *
     * @author misterbykl
     * @since 1.0.0
     */
    public static void setKisiListesi(List<String> argKisiListesi) {
        DGList.kisiListesi = argKisiListesi;
    }

    /**
     * @return
     * @author misterbykl
     *
     * @since 1.0.0
     */
    public static DateTimeFormatter getDateFormat() {
        return dateFormat;
    }
}
