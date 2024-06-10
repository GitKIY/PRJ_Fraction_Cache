package ru.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MakeCache implements InvocationHandler {
    private final Object obj;
    private final Map<Method,Object> cacheMap;

    public MakeCache(Object obj) {
        this.obj = obj;
        cacheMap = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method findMethod = obj.getClass().getMethod(method.getName(), method.getParameterTypes());

        if (findMethod.isAnnotationPresent(Cache.class)) {
            Object res;
            if (cacheMap.get(method) == null) {
                res = method.invoke(obj,args);
                cacheMap.put(method,res);
            } else res = cacheMap.get(method);
            return res;
        }
        if (findMethod.isAnnotationPresent(Mutator.class)) {
            cacheMap.clear();
        }

        return method.invoke(obj,args);
    }
}
