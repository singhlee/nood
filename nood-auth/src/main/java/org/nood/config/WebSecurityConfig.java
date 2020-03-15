package org.nood.config;

import org.nood.code.utils.RedisUtil;
import org.nood.filter.JwtAuthenticationTokenFilter;
import org.nood.security.*;
import org.nood.service.JwtUserDetailService;
import org.nood.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 * @program: nood
 * @description: Security 配置
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(-1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.ignored}")
    private String ignored;

    private JwtTokenUtil jwtTokenUtil;

    private RedisUtil redisUtil;

    /**
     *    未登陆时返回 JSON 格式的数据给前端（否则为 html）
     */
    private UserAuthenticationEntryPoint authenticationEntryPoint;

    /**
     *     自定义user
     */
    private JwtUserDetailService userDetailService;
    /**
     *    无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）
     */

    private  UserAccessDeniedHandler accessDeniedHandler;

    /**
     * 登录成功返回的 JSON 格式数据给前端（否则为 html）
     */
    private UserAuthenticationSuccessHandler authenticationSuccessHandler;
    /**
     * 登录失败返回的 JSON 格式数据给前端（否则为 html）
     */
    private UserAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 退出返回的 JSON 格式数据给前端（否则为 html）
     */
    private UserLogoutSuccessHandler userLogoutSuccessHandler;

//    private UserAuthenticationProvider userAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    public static void main(String[] args) {
         BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
         System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        String [] ignoredUrl=ignored.split(",");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/health");
        web.ignoring().antMatchers(ignoredUrl);
    }
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        String [] ignoredUrl=ignored.split(",");
        httpSecurity.csrf().disable();
        //跨域
        httpSecurity.cors();
         //使用 JWT，关闭token
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 未登录时：返回状态码401
        httpSecurity.httpBasic().authenticationEntryPoint(authenticationEntryPoint);

       //定义哪些URL需要被保护、哪些不需要被保护
        httpSecurity.authorizeRequests()
                    //对preflight放行
                    .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    .antMatchers(ignoredUrl).permitAll()
                    .anyRequest().authenticated();
        //开启登录, 定义当需要用户登录时候，转到的登录页面
        httpSecurity.formLogin()
                //loginProcessingUrl用于指定前后端分离的时候调用后台登录接口的名称
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                //配置登录成功的自定义处理类
                .successHandler(authenticationSuccessHandler)
                //配置登录失败的自定义处理类
                .failureHandler(authenticationFailureHandler)
                .permitAll();
        httpSecurity.logout()
                .logoutUrl("/logout")
                //配置退出成功的自定义处理类
                .logoutSuccessHandler(userLogoutSuccessHandler)
                .permitAll();
        // 无权访问 JSON 格式的数据
        httpSecurity.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        // 校验
        httpSecurity.addFilterBefore(new JwtAuthenticationTokenFilter(jwtTokenUtil,tokenHeader,userDetailService,redisUtil),
                UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void setAuthenticationEntryPoint(UserAuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }
    @Autowired
    public void setUserDetailService(JwtUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
    @Autowired
    public void setAccessDeniedHandler(UserAccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Autowired
    public void setAuthenticationSuccessHandler(UserAuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Autowired
    public void setAuthenticationFailureHandler(UserAuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Autowired
    public void setUserLogoutSuccessHandler(UserLogoutSuccessHandler userLogoutSuccessHandler) {
        this.userLogoutSuccessHandler = userLogoutSuccessHandler;
    }
//    @Autowired
//    public void setAuthenticationProvider(UserAuthenticationProvider userAuthenticationProvider) {
//        this.userAuthenticationProvider = userAuthenticationProvider;
//    }
}
