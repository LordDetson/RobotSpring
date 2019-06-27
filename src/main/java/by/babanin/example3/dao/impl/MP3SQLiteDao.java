package by.babanin.example3.dao.impl;

import by.babanin.example3.dao.interfaces.MP3Dao;
import by.babanin.example3.model.MP3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("mp3Dao")
public class MP3SQLiteDao implements MP3Dao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private SimpleJdbcInsert insert;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        insert = new SimpleJdbcInsert(dataSource)
                .withTableName("mp3")
                .usingColumns("name", "author");
        insert.setGeneratedKeyName("id");
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public int insert(MP3 mp3) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", mp3.getName());
        parameterSource.addValue("author", mp3.getAuthor());
        KeyHolder keyHolder = insert.executeAndReturnKeyHolder(parameterSource);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void insertAll(Collection<MP3> mp3Collection) {
        String sql = "insert into mp3 (name, author) VALUES (:name, :author)";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(mp3Collection);
        jdbcTemplate.batchUpdate(sql, batch);
    }

    @Override
    public void delete(MP3 mp3) {
        String sql = "delete from mp3 where id=:id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", mp3.getId());
        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public MP3 getMP3ById(int id) {
        String sql = "select * from mp3 where id=:id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return jdbcTemplate.queryForObject(sql, parameterSource, new MP3RowMapper());
    }

    @Override
    public List<MP3> getMP3ListByName(String name) {
        String sql = "select * from mp3 where upper(name) like :name";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        String s = "%" + name.toUpperCase() + "%";
        parameterSource.addValue("name", s);
        return jdbcTemplate.query(sql, parameterSource, new MP3RowMapper());
    }

    @Override
    public List<MP3> getMP3ListByAuthor(String author) {
        String sql = "select * from mp3 where upper(author) like :author";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        String s = "%" + author.toUpperCase() + "%";
        parameterSource.addValue("author", s);
        return jdbcTemplate.query(sql, parameterSource, new MP3RowMapper());
    }

    @Override
    public List<MP3> getAllMP3List() {
        String sql = "select * from mp3";
        return jdbcTemplate.query(sql, new MP3RowMapper());
    }

    @Override
    public int getMP3Count() {
        String sql = "select count(*) from mp3";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    @Override
    public Map<String, Integer> getMP3CountGroupByAuthor() {
        String sql = "select author, count(*) as count from mp3 group by author";
        return jdbcTemplate.query(sql, resultSet -> {
            Map<String, Integer> map = new HashMap<>();
            while (resultSet.next()) {
                String author = resultSet.getString("author");
                int count = resultSet.getInt("count");
                map.put(author, count);
            }
            return map;
        });
    }

    private static class MP3RowMapper implements RowMapper<MP3> {

        @Override
        public MP3 mapRow(ResultSet resultSet, int i) throws SQLException {
            MP3 mp3 = new MP3();
            mp3.setId(resultSet.getInt("id"));
            mp3.setName(resultSet.getString("name"));
            mp3.setAuthor(resultSet.getString("author"));
            return mp3;
        }
    }
}
