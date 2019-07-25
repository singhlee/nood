package org.nood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;

/**
 * @ProjectName: nood
 * @Package: org.nood.config
 * @ClassName: AuthorizationServerConfig
 * @Description: java类作用描述
 * @Author: LX
 * @CreateDate: 2018/9/20 16:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/20 16:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //若无，refresh_token会有UserDetailsService is required错误
        endpoints.authenticationManager(authenticationManager)
                 .userDetailsService(userDetailsService)
                 .tokenStore(tokenStore());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
}
