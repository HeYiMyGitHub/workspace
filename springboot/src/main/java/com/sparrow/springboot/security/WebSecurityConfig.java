package com.sparrow.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/","/login").permitAll()//1 对/和/login路径不拦截
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")//2设置登录页面访问路径为/login
                .defaultSuccessUrl("/chat")//3登录成功后转向/chat路径
                .permitAll().and().logout().permitAll();
    }

    //4 内存中分配用户名和密码，角色是USER
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("heyi").password("heyi").roles("USER")
                .and().withUser("test").password("test").roles("USER");
    }

    //5 /resources/static/目录下的静态资源不拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
