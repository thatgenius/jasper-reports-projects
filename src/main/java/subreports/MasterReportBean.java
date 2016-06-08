package subreports;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MasterReportBean {
    private SubreportBean subreportDataSource;
    private Map<String, SubreportBean> subreportDataSources;

    public Map<String, SubreportBean> getSubreportDataSources() {
        return subreportDataSources;
    }

    public void setSubreportDataSources(Map<String, SubreportBean> subreportDataSources) {
        this.subreportDataSources = subreportDataSources;
    }

    public SubreportBean getSubreportDataSource() {
        return subreportDataSource;
    }

    public void setSubreportDataSource(SubreportBean subreportDataSource) {
        this.subreportDataSource = subreportDataSource;
    }
}
