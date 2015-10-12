package receiver.ylf.com.receivermanager.com.ylf.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/12.
 *
 *  柱状图数据
 */
public class HistogramData implements Serializable {
    private  int id;
    private  String Name;
    private  int GreyValue;

    public HistogramData(int id,String name, int greyValue) {
        Name = name;
        GreyValue = greyValue;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public int getGreyValue() {
        return GreyValue;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setGreyValue(int greyValue) {
        GreyValue = greyValue;
    }
}
