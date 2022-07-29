package com.huntcn_front.service.huntbus.impl;

import com.huntcn_front.core.model.PageData;
import com.huntcn_front.core.model.PageWrap;
import com.huntcn_front.core.utils.ExampleBuilder;
import com.huntcn_front.dao.huntbus.HuntbusMapper;
import com.huntcn_front.dao.huntbus.model.Huntbus;
import com.huntcn_front.dao.huntbus.model.HuntbusExample;
import com.huntcn_front.service.huntbus.HuntbusService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 狩猎车表Service实现
 * @author FanJS
 * @date 2022/04/26 10:19
 */
@Service
public class HuntbusServiceImpl implements HuntbusService {

    @Autowired
    private HuntbusMapper huntbusMapper;

    @Override
    public Huntbus findById(Integer id) {
        return huntbusMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Huntbus> findByArea(String area) {
        return huntbusMapper.selectByarea(area);
    }


    @Override
    public List<Huntbus> findList(Huntbus huntbus) {
        ExampleBuilder<HuntbusExample, HuntbusExample.Criteria> builder = ExampleBuilder.create(HuntbusExample.class, HuntbusExample.Criteria.class);
        return huntbusMapper.selectByExample(builder.buildExamplePack(huntbus).getExample());
    }



    @Override
    public PageData<Huntbus> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<HuntbusExample, HuntbusExample.Criteria> builder = ExampleBuilder.create(HuntbusExample.class, HuntbusExample.Criteria.class);
        ExampleBuilder.ExamplePack<HuntbusExample, HuntbusExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(huntbusMapper.selectByExample(pack.getExample())));
    }
}
