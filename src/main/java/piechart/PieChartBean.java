package piechart;

import java.util.List;

public class PieChartBean {

    public List<PieChartItem> getPieChartData() {
        return pieChartData;
    }

    public void setPieChartData(List<PieChartItem> pieChartData) {
        this.pieChartData = pieChartData;
    }

    private List<PieChartItem> pieChartData;


    public static class PieChartItem {
        // meaningless comment //
        private String valueOne;
        private Integer valueTwo;

        public String getValueOne() {
            return valueOne;
        }

        public void setValueOne(String valueOne) {
            this.valueOne = valueOne;
        }

        public Integer getValueTwo() {
            return valueTwo;
        }

        public void setValueTwo(Integer valueTwo) {
            this.valueTwo = valueTwo;
        }
    }

}
