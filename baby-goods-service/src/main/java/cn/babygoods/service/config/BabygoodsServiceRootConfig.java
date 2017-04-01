package cn.babygoods.service.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jj_zhu on 2016/12/14.
 */
@Configuration
@EnableWebMvc
@ComponentScan("cn.babygoods.service")
public class BabygoodsServiceRootConfig extends WebMvcConfigurerAdapter {


}
