package com.huntcn_front.api.huntbus;

import com.huntcn_front.api.BaseController;
import com.huntcn_front.core.model.ApiResponse;
import com.huntcn_front.core.model.PageWrap;
import com.huntcn_front.dao.huntbus.model.Huntbus;
import com.huntcn_front.service.huntbus.HuntbusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 狩猎车表接口
 * @author FanJS
 * @date 2022/04/26 10:19
 */
@RestController
@RequestMapping("/huntbus")
@Api(tags = "狩猎车表接口")
public class HuntbusController extends BaseController {

    @Autowired
    private HuntbusService huntbusService;

    /**
     * 分页查询
     * @author FanJS
     * @date 2022/04/26 10:19
     */
    @PostMapping("/page")
    @ApiOperation("分页查询")
    public ApiResponse findPage (@RequestBody PageWrap<Huntbus> pageWrap) {
        return ApiResponse.success(huntbusService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author FanJS
     * @date 2022/04/26 10:19
     */
    @GetMapping("/{id}")
    @ApiOperation("根据ID查询")
    public ApiResponse findById(@PathVariable Integer id) {
        return ApiResponse.success(huntbusService.findById(id));
    }

    /**
     * 通过条件查询
     * @author FanJS
     * @date 2022/04/26 10:19
     */
    @GetMapping("/list")
    @ApiOperation("根据条件查询")
    public ApiResponse findList(@PathVariable Huntbus huntbus) {
        return ApiResponse.success(huntbusService.findList(huntbus));
    }

    @GetMapping("/findByArea/{area}")
    @ApiOperation("根据大区查询")
    public ApiResponse findByArea(@PathVariable String area) {
        return ApiResponse.success(huntbusService.findByArea(area));
    }
}
