package com.feijimiao.xianyuassistant.persistence;

import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

final class MongoFieldNames {
    private MongoFieldNames() {
    }

    static <T> String from(SFunction<T, ?> getter) {
        try {
            Method writeReplace = getter.getClass().getDeclaredMethod("writeReplace");
            writeReplace.setAccessible(true);
            SerializedLambda lambda = (SerializedLambda) writeReplace.invoke(getter);
            String method = lambda.getImplMethodName();
            if (method.startsWith("get")) {
                return Introspector.decapitalize(method.substring(3));
            }
            if (method.startsWith("is")) {
                return Introspector.decapitalize(method.substring(2));
            }
            throw new IllegalArgumentException("Unsupported property method: " + method);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalArgumentException("Unable to resolve MongoDB field name", exception);
        }
    }
}
