package com.demo.proxy.AopProxy.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class ProxyUtil {
    /**
     * 得到一个java文件
     * 编译成为一个class
     * 通过反射得到一个对象
     * @return
     */
    public static Object newProxyInstance(Object target) throws IOException {
        String content = "";
        String packageContent = "package com.demo.proxy;";
        Class targetInfo = target.getClass().getInterfaces()[0];
        String targetInfoName = targetInfo.getSimpleName();
        String importContent = "import "+targetInfo.getName()+";";
        String classContent = "public class $Proxy implements "+targetInfoName+"{";

        String fieldContent = "private "+targetInfoName+" target;";
        String construterContent = "public $Proxy("+targetInfoName+" target){"+"this.target = target;}";
        String methodsContent = "";
        Method[] methods = targetInfo.getDeclaredMethods();
        for(Method method:methods){
            String methodName = method.getName();
            Class returnType = method.getReturnType();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String argsContent = "";
            String argsNames = "";
            int i=0;
            for(Class<?> parameterType:parameterTypes){
                String simpleName = parameterType.getSimpleName();
                argsContent+= simpleName+" p"+i;
                argsNames+="p"+i+",";
                i++;
            }
            if(argsContent.length()>0){
                argsContent = argsContent.substring(0,argsContent.lastIndexOf(",")-1);
                argsNames = argsNames.substring(0,argsContent.lastIndexOf(",")-1);
            }
            methodsContent = "public "+returnType+" "+methodName+"("+argsContent+"){"
                    +"System.out.println(\"打印日志\");"
                    +"target. "+methodName+"("+argsNames+");}";

        }
        content+=packageContent+importContent+classContent+fieldContent+construterContent+methodsContent+"}";
        File file = new File("d:\\com\\demo\\$Proxy.java");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();
        return null;
    }
}
