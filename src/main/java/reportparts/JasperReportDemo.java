package reportparts;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * JasperReports simple example
 */
public class JasperReportDemo {

    private static String reportPartsPath = "src/main/reportparts/";
    private static String outputPath = "src/main/output/";
    private static String tocPartFileName = "TocPart";
    private static String tablePartFileNmae = "TablePart";
    private static String binderPartFileName = "Binder";

    public static void main(String[] args) {
        buildReport();
    }

    private static void buildReport() {
        BeanAsDataSource bean = getBean();
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPartsPath + binderPartFileName + ".jrxml");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singleton(bean));
            HashMap<String, Object> parameters = new HashMap();
            parameters.put("myList", Collections.singleton(bean));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath + binderPartFileName + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BeanAsDataSource getBean() {
        BeanAsDataSource myBean = new BeanAsDataSource();
        myBean.setOrderID(7);
        myBean.setShipCity("firstCity");
        myBean.setShipCountry("firstCountry");
        myBean.setShipName("firstShipName");
        myBean.setTotal(9);
        JasperReport tablePart = null;
        JasperReport tocPart = null;
        try {
            tocPart = JasperCompileManager.compileReport(reportPartsPath + tocPartFileName + ".jrxml");
            tablePart = JasperCompileManager.compileReport(reportPartsPath + tablePartFileNmae + ".jrxml");
        } catch (JRException e) {
            e.printStackTrace();
        }
        myBean.setTocPart(tocPart);
        myBean.setTablePart(tablePart);
        List<BeanAsDataSource.TableItem> items = new ArrayList();
        for (int i = 0; i<90; i++) {
            BeanAsDataSource.TableItem item = new BeanAsDataSource.TableItem();
            item.setRowOne(String.valueOf(i));
            item.setRowTwo(String.valueOf(i));
            item.setRowThree(String.valueOf(i));
            item.setRowFour(String.valueOf(i));
            items.add(item);
        }
        myBean.setItems(items);
        return myBean;
    }
}
