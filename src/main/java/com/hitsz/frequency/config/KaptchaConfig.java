package com.hitsz.frequency.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author yang
 * @create 2021-03-20 14:46
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public Producer kaptchaProducer(){
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width","100");
        properties.setProperty("kaptcha.image.height","40");
        properties.setProperty("kaptcha.textproducer.font.size","32");  //字号
        properties.setProperty("kaptcha.textproducer.font.color","0,0,0");  //黑色
        properties.setProperty("kaptcha.textproducer.char.string","012345679ABCDEFGHIJKLMNOPQRSTUVWXYZ");  //字符范围
        properties.setProperty("kaptcha.textproducer.char.length","4");  //生成几个随机字符
        properties.setProperty("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");  //采用哪个干扰类

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
