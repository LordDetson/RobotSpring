package by.babanin.example3;

import by.babanin.example3.dao.interfaces.MP3Dao;
import by.babanin.example3.model.MP3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("example3.xml");

        MP3Dao mp3Dao = context.getBean("mp3Dao", MP3Dao.class);
        MP3 mp3 = new MP3();
        mp3.setAuthor("Michael Jackson");
        mp3.setName("THE GIRL IS MINE");
        List<MP3> mp3List = new ArrayList<>();
        mp3List.add(mp3);

        mp3Dao.insertAll(mp3List);

        List<MP3> allMP3List = mp3Dao.getAllMP3List();
        allMP3List.forEach(System.out::println);
        int mp3Count = mp3Dao.getMP3Count();
        System.out.println(mp3Count);

        System.out.println();
        List<MP3> mp3ListByName = mp3Dao.getMP3ListByName(mp3.getName());
        mp3ListByName.forEach(System.out::println);

        System.out.println();
        List<MP3> mp3ListByAuthor = mp3Dao.getMP3ListByAuthor(mp3.getAuthor());
        mp3ListByAuthor.forEach(System.out::println);

        System.out.println();
        Map<String, Integer> mp3CountGroupByAuthor = mp3Dao.getMP3CountGroupByAuthor();
        mp3CountGroupByAuthor.forEach((s, integer) -> System.out.println("author=" + s + " count=" + integer));
    }
}
