package com.huntcn_front.service.huntbus;

import com.huntcn_front.core.model.PageData;
import com.huntcn_front.core.model.PageWrap;
import com.huntcn_front.dao.huntbus.model.Huntbus;
import java.util.List;

/**
 * 狩猎车表Service定义
 * @author FanJS
 * @date 2022/04/26 10:19
 */
public interface HuntbusService {

    /**
     * 主键查询
     * @author FanJS
     * @date 2022/04/26 10:19
     */
    Huntbus findById(Integer id);

    /**
     * 条件查询（大区）
     *
     * @author FanJS
     * @date 2022/04/26 10:19
     */
    List<Huntbus> findByArea(String area);


    /**
     * 条件查询
     * @author FanJS
     * @date 2022/04/26 10:19
     */
    List<Huntbus> findList(Huntbus huntbus);


    /**
     * 分页查询
     * @author FanJS
     * @date 2022/04/26 10:19
     */
    PageData<Huntbus> findPage(PageWrap<Huntbus> pageWrap);

}
