package com.xiaoji.duan.aac.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DatabaseMapper {

    @Update({ "${_parameter}" })
    void execute(String sql);
}
