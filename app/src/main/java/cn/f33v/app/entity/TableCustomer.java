package cn.f33v.app.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (TableCustomer)表实体类
 *
 * @author makejava
 * @since 2021-04-27 19:51:14
 */
@SuppressWarnings("serial")
public class TableCustomer extends Model<TableCustomer> {
    //客服id
    private Integer id;
    //客服姓名
    private String customerName;
    //客服电话
    private String customerPhone;
    //客服所属服务商id
    private Integer serverId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
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
