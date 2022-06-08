package com.example.fruits.mapper;

import com.example.fruits.domain.Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tk.mybatis.mapper.common.Mapper;

public interface AddressMapper extends Mapper<Address> {
    @Select("select count(*)>0  from t_order join order_item using(o_id) where add_id = #{addId}")
    boolean exists(@Param("addId") Integer addId);
    //删除的地址非活性显示
    // 2022/06/08  wang add start
    @Update("Update address set delete_flag = 1 where add_id = #{addId}")
     void deleteAddress(@Param("addId") Integer addId);
    // 2022/06/08 wang add end
}
