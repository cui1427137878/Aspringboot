package org.springioc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ApplicationContext {
    ArrayList<String> classNameList=new ArrayList<>();
    HashMap<String,Object> container=new HashMap<>();
    public  ApplicationContext() throws  Throwable{
        classNameList.add("com.tedu.UserServiceImpl");
        classNameList.add("com.tedu.UserController");
        loadObject();
        autowiredProcess();
    }

    private void autowiredProcess() throws Throwable{
        //遍历容器，取出每个对象
        //userController,userServiceImpl
        Set<String> set=container.keySet();
        for (String key:set){
            System.out.println("key="+key);
            Object object=container.get(key);
        //得到对象的属性
            Field[] fields=object.getClass().getDeclaredFields();
        //遍历所有属性
            for (Field field:fields) {
                //判断有没有加@autowired
                Autowired autowired=field.getAnnotation(Autowired.class);
                if (autowired!=null) {
                    //UserController
                    //@autowired
                    //UserService userServiceImpl
                    //从容器中找一个对象赋值给属性
                    String fieldName=field.getName();//userServiceImpl
                    Object serviceObject=container.get(fieldName);
                    field.setAccessible(true);
                    field.set(object,serviceObject);

                }
            }
            }
    }

    public  Object getBean(String objectName){
        return  container.get(objectName);
    }

    //加载对象到容器中
    private void loadObject() throws  Throwable {
        //遍历所有类
        for(String className:classNameList) {
            Class clazz=Class.forName(className);
            //判断这个类有没有加@service或@RestController
            Service service= (Service) clazz.getAnnotation(Service.class);
            RestController restController= (RestController)
                    clazz.getAnnotation(RestController.class);
            if (service!=null || restController!=null) {
                //创建一个对象
                Object object=clazz.newInstance();
                //创建一个key
                //com.tedu.UserController
                int begin=className.lastIndexOf(".")+1;
                //UserController
                String key=className.substring(begin);
                key=Character.toLowerCase(key.charAt(0))+key.substring(1);
                //把对象放到容器中
                container.put(key,object);
                System.out.println(key);
            }
        }
    }

}
