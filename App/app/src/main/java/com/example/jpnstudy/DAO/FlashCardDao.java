package com.example.jpnstudy.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.jpnstudy.Entities.FlashCard;

import java.util.List;

@Dao
public interface FlashCardDao {

    @Insert
    void insert(FlashCard flashCard);

    @Delete
    void delete(FlashCard flashCard);

    @Query("select * from flashcard " +
            "where card_type = (:type)")
    List<FlashCard> searchType(String type);

    @Query("select * from flashcard " +
            "where card_type = (:eng)")
    List<FlashCard> searchEnglish(String eng);

    @Query("select * from flashcard " +
            "where card_type = (:kanji)")
    List<FlashCard> searchKanji(String kanji);

    @Query("select * from flashcard " +
            "where card_type = (:hiragana)")
    List<FlashCard> searchHiragana(String hiragana);

    @Query("select * from flashcard " +
            "where card_mastered = (:mastered)")
    List<FlashCard> searchMastered(boolean mastered);

    @Query("select * from flashcard " +
            "where card_mastered = (:mastered) " +
            "LIMIT (:cardLimit)")
    List<FlashCard> searchMastered(boolean mastered, int cardLimit);


    @Query("select * from flashcard " +
            "where card_starred = (:starred) ")
    List<FlashCard> searchStarred(boolean starred);
    @Query("select * from flashcard " +
            "where card_starred = (:starred) " +
            "LIMIT (:cardLimit)")
    List<FlashCard> searchStarred(boolean starred, int cardLimit);

    @Query("select * from flashcard " +
            "where card_known = (:known) ")
    List<FlashCard> searchKnown(boolean known);
    @Query("select * from flashcard " +
            "where card_known = (:known) " +
            "LIMIT (:cardLimit)")
    List<FlashCard> searchKnown(boolean known, int cardLimit);

}
