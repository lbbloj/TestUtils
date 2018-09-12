package com.hzwq.testng;

import org.mockito.configuration.AnnotationEngine;
import org.mockito.configuration.DefaultMockitoConfiguration;
import org.mockito.exceptions.Reporter;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.GlobalConfiguration;
import org.mockito.internal.util.reflection.FieldSetter;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class MockitoAnnotations {
    public MockitoAnnotations() {
    }

    public static void initMocks(Object testClass) {
        if (testClass == null) {
            throw new MockitoException("testClass cannot be null. For info how to use @Mock annotations see examples in javadoc for MockitoAnnotations class");
        } else {
            AnnotationEngine annotationEngine = ( new GlobalConfiguration() ).getAnnotationEngine();
            Class<?> clazz = testClass.getClass();
            if (annotationEngine.getClass() != (new DefaultMockitoConfiguration()).getAnnotationEngine().getClass()) {
                while(clazz != Object.class) {
                    scanDeprecatedWay(annotationEngine, testClass, clazz);
                    clazz = clazz.getSuperclass();
                }
            }

            annotationEngine.process(testClass.getClass(), testClass);
        }
    }

    static void scanDeprecatedWay(AnnotationEngine annotationEngine, Object testClass, Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Field[] arr$ = fields;
        int len$ = fields.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Field field = arr$[i$];
            processAnnotationDeprecatedWay(annotationEngine, testClass, field);
        }

    }

    static void processAnnotationDeprecatedWay(AnnotationEngine annotationEngine, Object testClass, Field field) {
        boolean alreadyAssigned = false;
        Annotation[] arr$ = field.getAnnotations();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Annotation annotation = arr$[i$];
            Object mock = annotationEngine.createMockFor(annotation, field);
            if (mock != null) {
                throwIfAlreadyAssigned(field, alreadyAssigned);
                alreadyAssigned = true;

                try {
                    (new FieldSetter(testClass, field)).set(mock);
                } catch (Exception var10) {
                    throw new MockitoException("Problems setting field " + field.getName() + " annotated with " + annotation, var10);
                }
            }
        }

    }

    static void throwIfAlreadyAssigned(Field field, boolean alreadyAssigned) {
        if (alreadyAssigned) {
            (new Reporter()).moreThanOneAnnotationNotAllowed(field.getName());
        }

    }

    /** @deprecated */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface Mock {
    }
}
