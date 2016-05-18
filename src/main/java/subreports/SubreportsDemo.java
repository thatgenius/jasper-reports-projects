package subreports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.Collections;
import java.util.HashMap;

/**
 * JasperReports simple example: subreports
 */
public class SubreportsDemo {

    private static String reportPath = "src/main/subreports/";
    private static String outputPath = "src/main/output/";
    private static String subreportFileName = "Subreport";
    private static String binderFileName = "Binder";

    public static void main(String[] args) {
        buildReport();
    }

    private static void buildReport() {
        MasterReportBean bean = getBean();
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + binderFileName + ".jrxml");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singleton(bean));
            HashMap<String, Object> parameters = new HashMap();

            JasperReport compiledSubreport = null;
            try {
                compiledSubreport = JasperCompileManager.compileReport(reportPath + subreportFileName + ".jrxml");
            } catch (JRException e) {
                e.printStackTrace();
            }

            parameters.put("compiledSubreport", compiledSubreport);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath + binderFileName + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MasterReportBean getBean() {
        MasterReportBean masterReportBean = new MasterReportBean();
        SubreportBean subreportBean = new SubreportBean();
        subreportBean.setFieldOne("Subreport works!");
        masterReportBean.setSubreportDatasource(subreportBean);
        return masterReportBean;
    }
}
