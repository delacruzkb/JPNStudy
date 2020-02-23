package com.example.jpnstudy.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.jpnstudy.Entities.Grammar;
import com.example.jpnstudy.Entities.Word;

import java.util.List;

@Dao
public interface FlashCardDao {

    //=========Word Card Search======================
    @Query("select * from word " +
            "where card_mastered = (:mastered) " +
            "LIMIT (:cardLimit)")
    List<Word> loadMasteredWordCards(int mastered, int cardLimit);


    @Query("select * from word " +
            "where card_starred = (:starred) " +
            "LIMIT (:cardLimit)")
    List<Word> loadStarredWordCards(int starred, int cardLimit);

    @Query("select * from word " +
            "where card_known = (:known) " +
            "LIMIT (:cardLimit)")
    List<Word> loadKnownWordCards(int known, int cardLimit);

    //=========Grammar Card Search===================
    @Query("select * from grammar " +
            "where card_mastered = (:mastered) " +
            "LIMIT (:cardLimit)")
    List<Grammar> loadMasteredGrammarCards(int mastered, int cardLimit);


    @Query("select * from grammar " +
            "where card_starred = (:starred) " +
            "LIMIT (:cardLimit)")
    List<Grammar> loadStarredGrammarCards(int starred, int cardLimit);

    @Query("select * from grammar " +
            "where card_known = (:known) " +
            "LIMIT (:cardLimit)")
    List<Grammar> loadKnownGrammarCards(int known, int cardLimit);
}
