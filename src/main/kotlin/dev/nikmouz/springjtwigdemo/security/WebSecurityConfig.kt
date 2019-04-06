package dev.nikmouz.springjtwigdemo.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Value("\${spring.h2.console.enabled:false}")
    private val h2ConsoleEnabled: Boolean = false

    override fun configure(web: WebSecurity) {
        if (h2ConsoleEnabled) {
            web.ignoring()
                    .antMatchers("/h2-console/**")
                    .antMatchers("/*")
        }
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and().httpBasic()
                .and().csrf().disable()
    }
}
