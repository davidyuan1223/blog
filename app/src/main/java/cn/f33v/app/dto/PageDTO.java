package cn.f33v.app.dto;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class PageDTO<T> {
    private List<T> recordList;
    private Integer count;

    public PageDTO(List<T> recordList, Integer count) {
        this.recordList = recordList;
        this.count = count;
    }

    public PageDTO() {
    }
}
