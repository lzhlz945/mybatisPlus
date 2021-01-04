package com.zhang.pm.beans;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * javaBean
 * 
 * 定义JavaBean中成员变量时所使用的类型: 
 * 	 因为每个基本类型都有一个默认值:  
 * 	   int ==> 0
 * 	   boolean ==> false
 *
 */

/*
 * MybatisPlus会默认使用实体类的类名到数据中找对应的表. 
 * 
 */
@Data
//@TableName(value="tbl_employee")
public class Employee extends Model<Employee> {
	/*
	 * @TableId:
	 * 	 value: 指定表中的主键列的列名， 如果实体属性名与列名一致，可以省略不指定. 
	 *   type: 指定主键策略. 
	 */
//	@TableId(value = "id",type = IdType.AUTO)
	private Integer id ;   //  int 
	

	private String  lastName; 
	private String  email ;
	private Integer gender; 
	private Integer age ;
	@Version
	private Integer version;
    @TableField(exist = false)
	private Double salary ;


	@Override
	protected Serializable pkVal() {
		return id;
	}
}
