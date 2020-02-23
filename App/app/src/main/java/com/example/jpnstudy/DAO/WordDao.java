package com.example.jpnstudy.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.jpnstudy.Entities.Word;

import java.util.List;
@Dao
public interface WordDao {
    @Insert
    void insert(Word word);

    @Delete
    void delete(Word word);

    @Query("select * from word " +
            "where word_english LIKE '%' || (:english) || '%'")
    List<Word> searchEnglish(String english);

    @Query("select * from word " +
            "where word_japanese LIKE '%' || (:japanese) || '%'")
    List<Word> searchJapanese(String japanese);

    @Query("select * from word " +
            "where word_kanji LIKE '%' || (:kanji) || '%'")
    List<Word> searchKanji(String kanji);

    @Query("select * from word " +
            "where word_type LIKE '%' || (:type) || '%'")
    List<Word> searchType(String type);


}
