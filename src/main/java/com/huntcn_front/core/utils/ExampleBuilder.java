package com.huntcn_front.core.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * MyBatis工具类
 * @author FanJS
 * @date 2022/04/26 10:11
 */
public class ExampleBuilder<E, C> {

    private Class<E> exampleClass;

    private Class<C> criteriaClass;

    private ExampleBuilder(Class<E> exampleClass, Class<C> criteriaClass) {
        this.exampleClass = exampleClass;
        this.criteriaClass = criteriaClass;
    }

    /**
     * 创建ExampleBuilder对象
     * @author FanJS
     * @date 2022/04/26 10:11
     */
    public static <E,C> ExampleBuilder<E,C> create(Class<E> exampleClass, Class<C> criteriaClass) {
        return new ExampleBuilder<>(exampleClass, criteriaClass);
    }

    /**
     * 构建Example包装类
     * @author FanJS
     * @date 2022/04/26 10:11
     */
    public ExamplePack<E,C> buildExamplePack(Object model) {
        try {
            E example = exampleClass.newInstance();
            Method createCriteria = exampleClass.getMethod("createCriteria");
            Object criteria = createCriteria.invoke(example);
            if (model == null) {
                return new ExamplePack<>(example, (C)criteria);
            }
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(Boolean.TRUE);
                Object value = field.get(model);
                if (value != null && !"".equals(value)) {
                    String name = field.getName();
                    Method andMethod = criteria.getClass().getMethod(String.format("and%sEqualTo", name.substring(0, 1).toUpperCase() + name.substring(1)), field.getType());
                    andMethod.invoke(criteria, value);
                }
            }
            // 代码警告说明：编译阶段无法预知criteria所属类型
            return new ExamplePack<>(example, (C)criteria);
        } catch (Exception e) {
            throw new RuntimeException("Method 'toExample' of class ExampleBuilder throw an exception", e);
        }
    }

    /**
     * Example包装类，方便获取Example实例和当前构造的Criteria实例
     * @author FanJS
     * @date 2022/04/26 10:11
     */
    public static class ExamplePack<E, C> {

        private E example;

        private C criteria;
        
        public ExamplePack(E example, C criteria) {
            this.example = example;
            this.criteria = criteria;
        }
        
        public E getExample() {
            return example;
        }
        
        public C getCriteria() {
            return criteria;
        }

    }
}
