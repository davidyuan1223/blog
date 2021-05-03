package cn.f33v.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TableOrder)表实体类
 *
 * @author makejava
 * @since 2021-04-27 19:51:15
 */
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableOrder extends Model<TableOrder> implements Serializable {

    private String id;

    private Integer orderNum;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm")
    private Date orderTime;

    private String orderState;

    private Integer userId;

    private String userName;

    private String userNote;

    private String userAddress;

    private String userPhone;

    private Integer customerId;

}
