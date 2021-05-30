package com.hitsz.frequency.service;

import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.hitsz.frequency.dao.GlassMapper;
import com.hitsz.frequency.entity.Glass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang
 * @create 2021-04-15 9:16
 */
@Service
public class GlassService {
    @Autowired
    private GlassMapper glassMapper;

    public Glass findGlass(double width,double height,double thick,boolean frame){
        return glassMapper.queryGlass(width, height, thick,frame);
    }

    public Glass findGlassById(int id){
        return glassMapper.findGlassById(id);
    }

    public List<Glass> findGlasses(int offset,int limit){
        return glassMapper.queryGlasses(offset, limit);
    }

    public int findGlassRows(){
        return glassMapper.findGlassesRows();
    }

    public int addGlass(Glass glass){
        if (glass==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        return glassMapper.insertGlass(glass);
    }
    public int updateGlass(int id, Glass glass){
        return glassMapper.updateGlass(id,glass.getWidth(),glass.getHeight(),glass.getThick(),glass.getElasticModulus(),
                glass.getPoissonRatio(),glass.getUpper(),glass.getHighThreshold(),glass.getLowThreshold(),glass.getLower());
    }
    public int deleteGlass(int id){
        return glassMapper.deleteGlass(id, 0);
    }

}
