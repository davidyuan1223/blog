package cn.f33v.app.controller;

import cn.f33v.app.entity.TableOrder;
import cn.f33v.app.service.impl.TableOrderServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.f33v.app.result.Result;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/order")
@Api("订单模块")
public class TableOrderController {

    @Autowired
    private TableOrderServiceImpl tableOrderService;

    @GetMapping("/getOrderList")
    public Result getOrderList(@RequestParam(name = "current", required = true, defaultValue = "1") Integer current,
                               @RequestParam(name = "size", required = true, defaultValue = "5") Integer size,
                               @RequestParam(name = "username", required = false) String username) {
        Page<TableOrder> page = new Page<>(current, size);
        IPage<TableOrder> orderList = tableOrderService.selectPage(page, username);
        List<TableOrder> data = orderList.getRecords();
        long total = orderList.getTotal();
        return Result.ok().data("data", data).data("total", total);
    }

    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody TableOrder tableOrder) {
        if (tableOrderService.saveWithOutId(tableOrder) > 0) {
            return Result.ok().message("添加成功");
        } else {
            return Result.error().message("添加失败");
        }
    }

    @DeleteMapping("/deleteOrder")
    public Result deleteOrder(Integer id) {
        if (tableOrderService.removeById(id)) {
            return Result.ok().message("删除成功");
        } else {
            return Result.error().message("删除失败");
        }
    }

    @PutMapping("/updateOrder")
    public Result updateOrder(@RequestBody TableOrder tableOrder) {
        if (tableOrderService.updateById(tableOrder)) {
            return Result.ok().message("更新成功");
        } else {
            return Result.error().message("更新失败");
        }
    }
}
