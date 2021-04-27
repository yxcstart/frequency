package com.hitsz.frequency;

import com.hitsz.frequency.dao.GlassMapper;
import com.hitsz.frequency.entity.Glass;
import com.hitsz.frequency.service.GlassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author yang
 * @create 2021-04-15 9:33
 */
@SpringBootTest
@ContextConfiguration(classes = FrequencyApplication.class)
public class MapperTest {
    @Autowired
    private GlassMapper glassMapper;
    @Autowired
    private GlassService glassService;
    @Test
    public void testGlassMapper(){
        Glass glass = glassMapper.queryGlass(600, 600, 5);
        System.out.println(glass);
    }
    @Test
    public void testGlassService(){
        Glass glass = glassService.findGlass(600, 600, 5);
        System.out.println(glass);
    }
}
