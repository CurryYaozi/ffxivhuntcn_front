package com.huntcn_front.dao.huntbus;

import com.huntcn_front.dao.huntbus.model.Huntbus;
import com.huntcn_front.dao.huntbus.model.HuntbusExample;

  
import java.util.List;

public interface HuntbusMapper {

    List<Huntbus> selectByExample(HuntbusExample example);

    Huntbus selectByPrimaryKey(Integer id);

    List<Huntbus> selectByarea(String area);

}
