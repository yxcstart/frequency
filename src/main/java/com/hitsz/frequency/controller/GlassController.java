package com.hitsz.frequency.controller;

import com.hitsz.frequency.entity.Glass;
import com.hitsz.frequency.entity.Page;
import com.hitsz.frequency.entity.User;
import com.hitsz.frequency.service.GlassService;
import com.hitsz.frequency.util.CommunityUtils;
import com.hitsz.frequency.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


/**
 * @author yang
 * @create 2021-04-15 10:04
 */
@Controller
public class GlassController {
    @Autowired
    private GlassService glassService;
    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndex() {
        return "/index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.POST)
    public String query(Model model, Glass glassPara, double frequency) {
        Glass glass = glassService.findGlass(glassPara.getWidth(), glassPara.getHeight(), glassPara.getThick());
        String evaluation = null;
        double upper = glass.getUpper();
        double highThreshold = glass.getHighThreshold();
        double lowThreshold = glass.getLowThreshold();
        double lower = glass.getLower();
        if (frequency >= upper) {
            evaluation = "A";
        } else if (frequency >= highThreshold && frequency < upper) {
            evaluation = "B";
        } else if (frequency >= lowThreshold && frequency < highThreshold) {
            evaluation = "C";
        } else if (frequency >= lower && frequency < lowThreshold) {
            evaluation = "D";
        } else {
            evaluation = "E";
        }
        model.addAttribute("glass", glass);
        model.addAttribute("frequency", frequency);
        model.addAttribute("evaluation", evaluation);
        return "/index";
    }

    @RequestMapping(path = "/glass", method = RequestMethod.GET)
    public String getGlass(Model model, Page page) {
        page.setRows(glassService.findGlassRows());
        page.setPath("/glass");
        List<Glass> list = glassService.findGlasses(page.getOffset(), page.getLimit());
        model.addAttribute("glasses", list);
        return "/site/glass";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addGlass(double width, double height, double thick, double elasticModulus,
                           double poissonRatio, double upper, double lower) {
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtils.getJSONString(403, "只有管理员才能添加数据，请先登录！");
        }
        Glass glass = new Glass();
        glass.setWidth(width);
        glass.setHeight(height);
        glass.setThick(thick);
        glass.setElasticModulus(elasticModulus);
        glass.setPoissonRatio(poissonRatio);
        glass.setUpper(upper);
        glass.setHighThreshold(lower * 1.3);
        glass.setLowThreshold(lower * 1.2);
        glass.setLower(lower);
        glassService.addGlass(glass);
        return CommunityUtils.getJSONString(0, "数据库添加成功!");
    }

    @RequestMapping(path = "/detail/{glassId}", method = RequestMethod.GET)
    public String getGlassDetails(@PathVariable("glassId") int glassId, Model model) {
        Glass glass = glassService.findGlassById(glassId);
        model.addAttribute("glass", glass);
        return "/site/glass-detail";
    }

    @RequestMapping(path = "/update/{glassId}", method = RequestMethod.POST)
    public String updateGlass(@PathVariable("glassId") int glassId, Glass glassOld, Model model) {
        glassService.updateGlass(glassId, glassOld);
        Glass glass = glassService.findGlassById(glassId);
        model.addAttribute("glass", glass);
        return "/site/glass-detail";
    }

    @RequestMapping(path = "/delete/{glassId}", method = RequestMethod.GET)
    public String deleteGlass(@PathVariable("glassId") int glassId) {
        glassService.deleteGlass(glassId);
        return "redirect:/glass";
    }

}
