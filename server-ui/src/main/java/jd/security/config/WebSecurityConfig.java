package jd.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css", "/img", "/login", "/table").permitAll()//достуны для всех
                .antMatchers("/home").authenticated()
                .antMatchers("/error").authenticated()
                .antMatchers("/routes", "payments/**").hasAnyRole("ROOT", "MANAGER", "CLIENT")
                .antMatchers("/registerClient/**").hasAnyRole("ROOT", "MANAGER")
                .antMatchers("/registerManager/**").hasRole("ROOT")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                .withUser("client").password("111").roles("CLIENT")//вход клиент
                .and()
                .withUser("manager").password("qwerty").roles("MANAGER", "CLIENT")//вход менеджера
                .and()
                .withUser("root").password("root111").roles("ROOT", "MANAGER", "CLIENT");//вход админа
    }
}
