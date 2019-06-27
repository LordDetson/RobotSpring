package by.babanin.example3.dao.interfaces;

import by.babanin.example3.model.MP3;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface MP3Dao {
    int insert(MP3 mp3);

    void insertAll(Collection<MP3> mp3Collection);

    void delete(MP3 mp3);

    MP3 getMP3ById(int id);

    List<MP3> getMP3ListByName(String name);

    List<MP3> getMP3ListByAuthor(String author);

    List<MP3> getAllMP3List();

    int getMP3Count();

    Map<String, Integer> getMP3CountGroupByAuthor();
}
