package com.abcc.mydataapi.config;

import com.abcc.mydataapi.common.handler.AsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    /*
        CorePoolSize : 최초 동작 시에 corePoolSize만큼 스레드가 생성하여 사용된다.(Default 1)
        MaxPoolSize : Queue 사이즈 이상의 요청이 들어오게 될 경우, 스레드의 개수를 MaxPoolSize만큼 늘린다.(Default : Integer.MAX_VAULE)
        QueueCapacity : CorePoolSize 이상의 요청이 들어올 경우, LinkedBlockingQueue에서 대기하게 되는데 그 Queue의 사이즈를 지정해주는 것이다.(Default : Integer.MAX_VAULE)
        SetThreadNamePrefix : 스레드명 설정
     */
    @Bean(name = "pullPersonalInfoExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setMaxPoolSize(1000);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("MYDATA-PULL-ASYNC-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler(); // 추가
    }
}
