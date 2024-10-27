package com.caijiale.paipai.base.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author MAKABAKA
 */
@Data
public class PageResult<T> implements Serializable {
    //当前页
    private Integer pageNo = 1;
    //每页显示数量
    private Integer pageSize = 20;
    //总记录数
    private Integer total = 0;
    //总页数
    private Integer totalPage = 0;
    //结果集
    private List<T> result = Collections.emptyList();

    public static PageResult of(IPage page) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNo((int) page.getCurrent());
        pageResult.setPageSize((int) page.getSize());
        pageResult.setTotal((int) page.getTotal());
        pageResult.setTotalPage((int) page.getPages());
        pageResult.setResult(page.getRecords());
        return pageResult;
    }

    public void setTotal(Integer total) {
        this.total = total;
        if (pageSize > 0) {
            totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        } else {
            totalPage = 0;
        }
    }
}
