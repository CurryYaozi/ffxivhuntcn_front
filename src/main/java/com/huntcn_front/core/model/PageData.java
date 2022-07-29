package com.huntcn_front.core.model;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author FanJS
 * @date 2022/04/26 10:11
 */
@Data
public class PageData<T> implements Serializable {

    // 目标页
    private int page;

    // 一页多少行
    private int capacity;

    // 总记录数
    private long total;

    // 当前的数据
    private List<T> records;

    public PageData(int page, int capacity) {
        this.page = page;
        this.capacity = capacity;
    }
  
    public static <T> PageData<T> from(PageInfo<T> pageInfo) {
        PageData<T> pageData = new PageData<>(pageInfo.getPageNum(), pageInfo.getPageSize());
        pageData.total = pageInfo.getTotal();
        pageData.records = pageInfo.getList();
        return pageData;
    }

    /**
     * 处理异常页容量
     * @author FanJS
     * @date 2022/04/26 10:11
     */
    public int getCapacity () {
        return capacity <= 0 ? 10 : capacity;
    }

    /**
     * 计算总页码
     * @author FanJS
     * @date 2022/04/26 10:11
     */
    public long getPageCount(){
        if(this.getTotal() % this.getCapacity() == 0){
            long pc = this.getTotal()/this.getCapacity();
            return pc == 0 ? 1 : pc;
        }
        return this.getTotal()/this.getCapacity() + 1;
    }

}
