package com.caijiale.paipai.base.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页请求实体
 *
 * @author MAKABAKA
 */
public class PageRequest {
    private Integer pageNo = 1;

    private Integer pageSize = 20;
    private String orderBy;

    private String orderType;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            return 20;
        }
        return pageSize;
    }

    public Page toPage() {
        return new Page<>(getPageNo(), getPageSize(), true);
    }
}
