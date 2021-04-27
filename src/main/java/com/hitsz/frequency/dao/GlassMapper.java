package com.hitsz.frequency.dao;

import com.hitsz.frequency.entity.Glass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @create 2021-04-15 9:14
 */
@Mapper
public interface GlassMapper {
    Glass queryGlass(@Param("width") double width,@Param("height") double height, @Param("thick")double thick);
}
