package subreports;

import java.util.List;

public class MasterReportBean {
    private SubreportBean subreportDataSource;
    private List<SubreportsDemo.SubreportWrapper> subreportDataSources;

    public List<SubreportsDemo.SubreportWrapper> getSubreportDataSources() {
        return subreportDataSources;
    }

    public void setSubreportDataSources(List<SubreportsDemo.SubreportWrapper> subreportDataSources) {
        this.subreportDataSources = subreportDataSources;
    }

    public SubreportBean getSubreportDataSource() {
        return subreportDataSource;
    }

    public void setSubreportDataSource(SubreportBean subreportDataSource) {
        this.subreportDataSource = subreportDataSource;
    }
}
