package com.example.jpnstudy.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.jpnstudy.Entities.Grammar;
import java.util.List;

@Dao
public interface GrammarDao {
    @Insert
    void insert(Grammar grammar);

    @Delete
    void delete(Grammar grammar);

    @Query("delete from grammar")
    void deleteAllGrammar();

    @Query("select * from grammar " +
            "where grammar_name LIKE '%' || (:name) || '%'")
    List<Grammar> searchGrammarName(String name);

    @Query("select * from grammar " +
            "where grammar_definition LIKE '%' || (:def) || '%'")
    List<Grammar> searchGrammarDefinition(String def);

    @Query("select * from grammar " +
            "where grammar_example LIKE '%' || (:ex) || '%'")
    List<Grammar> searchGrammarExample(String ex);



}
