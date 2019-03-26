package my.boot.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author luoliang
 * @date 2019-03-26
 */
@Configuration
@ConditionalOnClass(MyDataTemplate.class)
@EnableConfigurationProperties(DataProperties.class)
public class MyDataTemplateAutoConfiguration {
    @Resource
    private DataProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "data", value = "enabled", havingValue = "true")
    public MyDataTemplate myDataTemplate() {
        return new MyDataTemplate(properties.getUrl(), properties.getType());
    }
}
