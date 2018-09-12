package com.hzwq.testng;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Alan
 * @Date: 2018-08-01
 * <p>
 * 自动注入mock对象,前提是：测试类方法中的mock字段必须提供get方法才能自动注入成功
 */
public class MockUtils  extends AbstractTestNGSpringContextTests {
    public MockUtils(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void init(){
        autoMocking(this);
    }
    /**
     * 给定一个对象，将对象的字段的字段替换成mock对象
     *
     * @param obj 给定的对象
     */
    public  void autoMocking(Object obj) {

        //获取对象的字段名称集合
        String[] objectFieldNames = getObjectFieldNames(obj);
        //获取对象字段对象
        List objectFields = getObjectField(obj);

        for (Object objectField : objectFields) {
            //获取对象字段的字段名称集合
            String[] objectFieldFieldNames = getObjectFieldNames(objectField);

            //判断如果字段的字段名称包含对象的字段名称，那么将这个字段反射注入该字段中
            for (int i = 0; i < objectFieldFieldNames.length; i++) {
                for (int j = 0; j < objectFieldNames.length; j++) {
                    if (objectFieldFieldNames[i].contains(objectFieldNames[j])) {
                        ReflectionTestUtils.setField(objectField, objectFieldFieldNames[i], objectFields.get(j));
                    }
                }

            }

        }

    }

    /**
     * 获取对象里面的所有字段对象
     */

    private  List getObjectField(Object obj) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        List objectFields = new ArrayList();

        for (Field declaredField : declaredFields) {
            String objectFieldName = declaredField.getName();
            Object objectFieldObjcet = getFieldValueByName(objectFieldName, obj);
            objectFields.add(objectFieldObjcet);
        }

        return objectFields;
    }

    /**
     * 获取对象里面的所有字段名称
     */

    private  String[] getObjectFieldNames(Object obj) {
        if ( obj == null ) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i].getName());
            if (i < fields.length - 1) {
                sb.append(",");
            }

        }
        return sb.toString().split(",");
    }


    /* 根据属性名获取属性值
     * */
    private  Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            // System.out.println(getter);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {

            return null;
        }
    }
}
