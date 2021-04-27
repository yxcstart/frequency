package com.hitsz.frequency.service;

import com.hitsz.frequency.dao.GlassMapper;
import com.hitsz.frequency.entity.Glass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yang
 * @create 2021-04-15 9:16
 */
@Service
public class GlassService {
    @Autowired
    private GlassMapper glassMapper;

    public Glass findGlass(double width,double height,double thick){
        return glassMapper.queryGlass(width, height, thick);
    }

}
