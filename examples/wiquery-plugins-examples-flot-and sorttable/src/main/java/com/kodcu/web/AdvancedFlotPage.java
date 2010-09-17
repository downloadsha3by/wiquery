
package com.kodcu.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.objetdirect.wiqueryplugins.ui.flot.AdvancedFlot;
import org.objetdirect.wiqueryplugins.ui.flot.AdvancedFlotData;

/**
 *
 * @author Altug Bilgin ALTINTAS
 */
public class AdvancedFlotPage extends WebPage {

    public AdvancedFlotPage() {
        AdvancedFlot advancedFlot = new AdvancedFlot("MyFlot");      

        advancedFlot.setChartData( getData());

        add(advancedFlot);
    }

    /**
     * Gets sample  data
     * @return data
     */
    private List<AdvancedFlotData> getData() {
        List<AdvancedFlotData> dataCollection = new ArrayList<AdvancedFlotData>();
        Calendar calendar = Calendar.getInstance();

        AdvancedFlotData data1 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 2);
        data1.setxValue(calendar);
        data1.setyValue(1);
        dataCollection.add(data1);

        AdvancedFlotData data2 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 8);
        data2.setxValue(calendar);
        data2.setyValue(2);
        dataCollection.add(data2);

        AdvancedFlotData data3 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 16);
        data3.setxValue(calendar);
        data3.setyValue(3);
        dataCollection.add(data3);

        AdvancedFlotData data4 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 25);
        data4.setxValue(calendar);
        data4.setyValue(4);
        dataCollection.add(data4);

        return dataCollection;
    }
}