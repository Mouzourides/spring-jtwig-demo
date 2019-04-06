package dev.nikmouz.springjtwigdemo

import org.jtwig.environment.EnvironmentConfigurationBuilder
import org.jtwig.hot.reloading.HotReloadingExtension
import org.jtwig.spring.JtwigViewResolver
import org.jtwig.spring.boot.config.JtwigViewResolverConfigurer
import org.jtwig.web.servlet.JtwigRenderer
import org.springframework.context.annotation.Configuration

@Configuration
class WebConfig: JtwigViewResolverConfigurer {
    override fun configure(viewResolver: JtwigViewResolver) {
        viewResolver.renderer = JtwigRenderer(
                EnvironmentConfigurationBuilder.configuration()
                        .extensions()
                        .add(HotReloadingExtension())
                        .and()
                        .build()
        )
        viewResolver.setSuffix(".twig")
    }
}
