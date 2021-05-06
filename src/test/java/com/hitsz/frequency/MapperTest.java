package com.hitsz.frequency;

import com.hitsz.frequency.dao.GlassMapper;
import com.hitsz.frequency.dao.LoginTicketMapper;
import com.hitsz.frequency.entity.Glass;
import com.hitsz.frequency.entity.LoginTicket;
import com.hitsz.frequency.service.GlassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private LoginTicketMapper loginTicketMapper;
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
    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket(0, 101, "abc", 0, new Date(System.currentTimeMillis() + 1000 * 60 * 10));
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectAndUpdateLoginTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
        loginTicketMapper.updateStatus("abc", 1);
        System.out.println(loginTicketMapper.selectByTicket("abc"));
    }
    @Test
    public void testQueryGlasses(){
        List<Glass> glasses = glassService.findGlasses(0, 20);
        for (Glass glass:glasses){
            System.out.println(glass);
        }
    }
    @Test
    public void testFindRows(){
        int glassRows = glassService.findGlassRows();
        System.out.println(glassRows);
    }
    @Test
    public void testInsertGlass(){
        Glass glass = new Glass(0, 300, 400, 2, 72000, 0.2, 100, 80, 30, 10);
        glassMapper.insertGlass(glass);
    }
    @Test
    public void testFindGlassById(){
        Glass glass = glassMapper.findGlassById(18);
        System.out.println(glass);
    }

    @Test
    public void updateGlass(){
        Glass glass = new Glass(0, 300, 400, 2, 72000, 0.2, 100, 80, 30, 10);
        glassService.updateGlass(19, glass);
    }

    @Test
    public void deleteGlass(){
        glassService.deleteGlass(18);
    }

}
