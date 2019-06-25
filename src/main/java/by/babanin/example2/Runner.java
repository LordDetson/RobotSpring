package by.babanin.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("example2.xml");
        FileManager fileUtil = context.getBean("manager", FileManager.class);
        fileUtil.getExtensionCount("c:\\Windows\\System32");
        fileUtil.getExtensionList("c:\\Windows\\");
    }
}
