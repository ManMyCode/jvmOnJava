package java.bean.postprocessor;

/**
 * Description: Aop 后置处理器
 * Datetime:    2020/11/1   8:18 下午
 * Author:   王震
 */
public interface AopPostProcessor {
    Object postProcessWeaving(Object bean, String beanName) throws Exception;
}
