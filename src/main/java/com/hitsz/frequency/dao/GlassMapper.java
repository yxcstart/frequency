package com.hitsz.frequency.dao;

import com.hitsz.frequency.entity.Glass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yang
 * @create 2021-04-15 9:14
 */
@Mapper
public interface GlassMapper {
    Glass queryGlass(@Param("width") double width, @Param("height") double height, @Param("thick") double thick);

    Glass findGlassById(int id);

    List<Glass> queryGlasses(@Param("offset") int offset, @Param("limit") int limit);

    int findGlassesRows();

    int insertGlass(Glass glass);

    int updateGlass(@Param("id") int id, @Param("width") double width, @Param("height") double height, @Param("thick") double thick,
                    @Param("elasticModulus") double elasticModulus, @Param("poissonRatio") double poissonRatio, @Param("upper") double upper,
                    @Param("highThreshold") double highThreshold, @Param("lowThreshold") double lowThreshold, @Param("lower") double lower);

    int deleteGlass(@Param("id") int id,@Param("status") int status);
}
