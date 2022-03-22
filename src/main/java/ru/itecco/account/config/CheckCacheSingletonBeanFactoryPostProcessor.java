
package ru.itecco.account.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.itecco.account.annotation.CacheResult;

import java.lang.reflect.Method;

/**
 * CheckCacheSingletonBeanFactoryPostProcessor.
 *
 * @author Belan Iliya
 */
@Component
@Slf4j
public class CheckCacheSingletonBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.isPrototype()) {
                String beanClassName = beanDefinition.getBeanClassName();
                Class<?> beanClass = Class.forName(beanClassName);
                for (Method method : beanClass.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(CacheResult.class)) {
                        log.warn("Bean: {} with Scope = prototype mark annotation @CacheResult", beanDefinitionName);
                    }
                }
            }
        }
    }

}