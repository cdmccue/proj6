package edu.usm.cos375.springboot.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync(proxyTargetClass = true)
@EnableScheduling
@ComponentScan(
        basePackages = "edu.usm.cos375.springboot",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootContextConfiguration
        implements AsyncConfigurer, SchedulingConfigurer
{

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

	@Override
	public void configureTasks(ScheduledTaskRegistrar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}
}
