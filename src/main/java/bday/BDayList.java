package bday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.StreamHandler;

/**
 * Created by misterb on 03/05/16.
 */
public class BDayList {

    public static final String EMRE = "14 Temmuz";
    public static final String SEDA = "28 Eylül";
    public static final String ERSEN = "10 Ağustos";
    public static final String BASAK = "30 Ağustos";
    public static final String MURAT = "13 Temmuz";
    public static final String SENEM = "4 Mayıs";
    public static final String ISIL = "30 Mayıs";
    public static final String CAGLAR = "4 Kasım";
    public static final String BEGUM = "8 Nisan";
    public static final String SUHAN = "25 Kasım";
    public static final String SINAN = "30 Haziran";
    public static final String MERT = "20 Temmuz";


    public static Map getDGList() {
        Map<String, String> dgListesi = new HashMap<String, String>();
        dgListesi.put("emre", BDayList.EMRE);
        dgListesi.put("seda", BDayList.SEDA);
        dgListesi.put("ersen", BDayList.ERSEN);
        dgListesi.put("basak", BDayList.BASAK);
        dgListesi.put("murat", BDayList.MURAT);
        dgListesi.put("senem", BDayList.SENEM);
        dgListesi.put("isil", BDayList.ISIL);
        dgListesi.put("caglar", BDayList.CAGLAR);
        dgListesi.put("begum", BDayList.BEGUM);
        dgListesi.put("suhan", BDayList.SUHAN);
        dgListesi.put("sinan", BDayList.SINAN);
        dgListesi.put("mert", BDayList.MERT);

        return dgListesi;
    }
}
