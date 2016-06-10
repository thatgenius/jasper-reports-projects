package piechart;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * JasperReports simple example: subreports
 */
public class PieChartDemo {

    private static String reportPath = "src/main/piechart/";
    private static String outputPath = "src/main/output/";
    private static String reportFileName = "piechart";

    public static void main(String[] args) {
        buildReport();
    }

    private static void buildReport() {
        PieChartBean bean = getBean();
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + reportFileName + ".jrxml");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singleton(bean));
            HashMap<String, Object> parameters = new HashMap();

            JasperReport compiledSubreport = null;
            try {
                compiledSubreport = JasperCompileManager.compileReport(reportPath + reportFileName + ".jrxml");
            } catch (JRException e) {
                e.printStackTrace();
            }

            parameters.put("compiledSubreport", compiledSubreport);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath + reportFileName + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PieChartBean getBean() {
        PieChartBean pieChartBean = new PieChartBean();

        PieChartBean.PieChartItem itemOne = new PieChartBean.PieChartItem();
        itemOne.setValueOne("valueOne");
        itemOne.setValueTwo(1);

        PieChartBean.PieChartItem itemTwo = new PieChartBean.PieChartItem();
        itemTwo.setValueOne("valueTwo");
        itemTwo.setValueTwo(2);

        PieChartBean.PieChartItem itemThree = new PieChartBean.PieChartItem();
        itemThree.setValueOne("valueThree");
        itemThree.setValueTwo(3);

        PieChartBean.PieChartItem itemFour = new PieChartBean.PieChartItem();
        itemFour.setValueOne("valueFour");
        itemFour.setValueTwo(4);

        PieChartBean.PieChartItem itemFive = new PieChartBean.PieChartItem();
        itemFive.setValueOne("valueFive");
        itemFive.setValueTwo(5);


        pieChartBean.setPieChartData(Arrays.asList(itemOne, itemTwo, itemThree, itemFour, itemFive));
        return pieChartBean;
    }




}
