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

    @Query("delete from word")
    public void deleteAllWords();

    @Query("select * from word " +
            "where word_english LIKE '%' || (:english) || '%'")
    List<Word> searchEnglish(String english);

    @Query("select * from word " +
            "where word_hiragana LIKE '%' || (:hiragana) || '%'")
    List<Word> searchHiragana(String hiragana);

    @Query("select * from word " +
            "where word_kanji LIKE '%' || (:kanji) || '%'")
    List<Word> searchKanji(String kanji);

    @Query("select * from word " +
            "where word_type LIKE '%' || (:type) || '%'")
    List<Word> searchType(String type);


}
