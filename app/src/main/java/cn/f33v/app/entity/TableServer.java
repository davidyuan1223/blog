package cn.f33v.app.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (TableServer)表实体类
 *
 * @author makejava
 * @since 2021-04-27 19:51:15
 */
@SuppressWarnings("serial")
public class TableServer extends Model<TableServer> {
    //服务商id
    private Integer id;
    //服务商姓名
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
