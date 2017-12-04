package edu.usm.cos375.springboot.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//import org.apache.catalina.startup.Tomcat;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.core.Ordered;

import java.nio.charset.StandardCharsets;
//import java.util.Hashtable;
//import java.util.Map;
import java.util.concurrent.Executor;

//import javax.persistence.SharedCacheMode;
//import javax.persistence.ValidationMode;
//import javax.sql.DataSource;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;


@Configuration
@EnableAsync(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.HIGHEST_PRECEDENCE
)
@EnableTransactionManagement(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.LOWEST_PRECEDENCE
)
@EnableScheduling
@ComponentScan(
        basePackages = "edu.usm.cos375.springboot",
        excludeFilters =
        @ComponentScan.Filter({Controller.class, ControllerAdvice.class})
)
public class RootContextConfiguration
        implements AsyncConfigurer, SchedulingConfigurer
{

    @Bean
    public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasenames(
                "/WEB-INF/i18n/titles", "/WEB-INF/i18n/messages",
                "/WEB-INF/i18n/errors", "/WEB-INF/i18n/validation"
        );
        return messageSource;
    }
    
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean()
    {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(this.messageSource());
        return validator;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        MethodValidationPostProcessor processor =
                new MethodValidationPostProcessor();
        processor.setValidator(this.localValidatorFactoryBean());
        return processor;
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,
                false);
        return mapper;
    }
    
//    @Bean
//    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
//        return new TomcatEmbeddedServletContainerFactory() {
//            @Override
//            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
//                    Tomcat tomcat) {
//                tomcat.enableNaming();
//                return super.getTomcatEmbeddedServletContainer(tomcat);
//            }
//        };
//    }
//    
//    @Bean
//    public DataSource springJpaDataSource()
//    {
//        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
//        return lookup.getDataSource("jdbc/DogsDB");
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
//    {
//        Map<String, Object> properties = new Hashtable<>();
//        properties.put("javax.persistence.schema-generation.database.action",
//                "none");
//
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
//
//        LocalContainerEntityManagerFactoryBean factory =
//                new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(adapter);
//        factory.setDataSource(this.springJpaDataSource());
//        factory.setPackagesToScan("edu.usm.cos375.springboot.entity");
//        factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
//        factory.setValidationMode(ValidationMode.NONE);
//        factory.setJpaPropertyMap(properties);
//        return factory;
//    }
//
//    @Bean
//    public PlatformTransactionManager jpaTransactionManager()
//    {
//        return new JpaTransactionManager(
//                this.entityManagerFactoryBean().getObject()
//        );
//    }

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
		return null;
	}
}

