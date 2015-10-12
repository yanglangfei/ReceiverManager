package receiver.ylf.com.receivermanager.com.ylf.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/12.
 *
 *  数据实体类
 */
public class PageViewData implements Serializable {
    private  int id;
    /**
     * y 轴
     */
    private  int PageViewValue;
    private  int Date;

    public PageViewData(int id,int pageViewValue, int date) {
        PageViewValue = pageViewValue;
        Date = date;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageViewValue() {
        return PageViewValue;
    }

    public int getDate() {
        return Date;
    }

    public void setPageViewValue(int pageViewValue) {
        PageViewValue = pageViewValue;
    }

    public void setDate(int date) {
        Date = date;
    }
}
