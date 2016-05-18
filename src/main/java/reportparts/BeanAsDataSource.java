package reportparts;

import net.sf.jasperreports.engine.JasperReport;

import java.util.List;

public class BeanAsDataSource {
    private int orderID;
    private String shipCity;
    private String shipCountry;
    private String shipName;
    private int total;
    private JasperReport tocPart;
    private JasperReport tablePart;
    private List<TableItem> items;

    public List<TableItem> getItems() {
        return items;
    }

    public void setItems(List<TableItem> items) {
        this.items = items;
    }

    public String getShipName() {
        return shipName;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTocPart(JasperReport tocPart) {
        this.tocPart = tocPart;
    }

    public JasperReport getTocPart() {
        return tocPart;
    }

    public void setTablePart(JasperReport tablePart) {
        this.tablePart = tablePart;
    }

    public JasperReport getTablePart() {
        return tablePart;
    }

    public static class TableItem {
        private String rowOne;
        private String rowTwo;
        private String rowThree;
        private String rowFour;

        public String getRowOne() {
            return rowOne;
        }

        public void setRowOne(String rowOne) {
            this.rowOne = rowOne;
        }

        public String getRowTwo() {
            return rowTwo;
        }

        public void setRowTwo(String rowTwo) {
            this.rowTwo = rowTwo;
        }

        public String getRowThree() {
            return rowThree;
        }

        public void setRowThree(String rowThree) {
            this.rowThree = rowThree;
        }

        public String getRowFour() {
            return rowFour;
        }

        public void setRowFour(String rowFour) {
            this.rowFour = rowFour;
        }
    }

}
