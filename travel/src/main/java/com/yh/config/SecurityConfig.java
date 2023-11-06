package com.yh.config;

import com.yh.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/6 - 11 - 06 - 11:12
 * @Description: com.yh.config
 * @version: 1.0
 */
 /** JSR:Java Specification Requests;java 规范提案; 新JDK版本出来的。
  * *      250号提案
  */
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
//    @EnableGlobalMethodSecurity(securedEnabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //依赖注入,顺序，在创建UserService之后;
    @Resource
    UserService userService;

    /**
     * 重写父类方法;
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义表单登录页面,现在没有自定i有登陆页面。
        http.formLogin()
                //指定登录页面
                .loginPage("/to/login")
                //指定登录请求
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successForwardUrl("/to/index")
                .failureUrl("/to/failer")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/to/login")
                .invalidateHttpSession(true)                //是否清除session
                .and()
                //权限配置
                .authorizeRequests()
                //放行 登录页面
                .antMatchers("/to/login","/to/failer").permitAll()
                //放开 静态资源
                .antMatchers("/css/**","/img/**","/js/**","/plugins/**").permitAll()
                //其他 资源需要登录后访问
                .anyRequest().authenticated()
                .and()
                //禁用csrf
                .csrf().disable();
        //没有权限，访问拒绝页面
        http.exceptionHandling().accessDeniedPage("/to/403");
    }

    /**
     * 对安全用安正管理构建器，进行重写
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //指定UserService对象的密码进制；
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    /**
     * @Bean:表示该方法，返回一个Bean对象，放置在Spring容器，被Spring容器托管.
     * BCrypt加密机制;
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
