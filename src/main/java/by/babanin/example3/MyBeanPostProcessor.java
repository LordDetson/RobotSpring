package by.babanin.example3;

import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    private Logger logger;

    public MyBeanPostProcessor(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info(String.format("Before initialization bean - %s", bean.getClass().getName()));
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info(String.format("After initialization bean - %s", bean.getClass().getName()));
        return bean;
    }
}
