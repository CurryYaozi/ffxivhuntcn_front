package com.huntcn_front.dao.huntbus.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 狩猎车表
 * @author FanJS
 * @date 2022/04/26 10:19
 */
@Data
@ApiModel("狩猎车表")
public class Huntbus {

    @ApiModelProperty(value = "序号", example = "1")
    private Integer id;

    @ApiModelProperty(value = "大区")
    private String area;

    @ApiModelProperty(value = "服务器")
    private String server;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "地图")
    private String map;

    @ApiModelProperty(value = "路线")
    private String road;

    @ApiModelProperty(value = "开车时间")
    private String time;

    @ApiModelProperty(value = "备注")
    private String note;

}
