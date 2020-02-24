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
            "where card_mastered = (:mastered)")
    List<Word> searchMasteredWordCards(int mastered);

    @Query("select * from word " +
            "where card_mastered = (:mastered) " +
            "LIMIT (:cardLimit)")
    List<Word> searchMasteredWordCards(int mastered, int cardLimit);


    @Query("select * from word " +
            "where card_starred = (:starred) ")
    List<Word> searchStarredWordCards(int starred);
    @Query("select * from word " +
            "where card_starred = (:starred) " +
            "LIMIT (:cardLimit)")
    List<Word> searchStarredWordCards(int starred, int cardLimit);

    @Query("select * from word " +
            "where card_known = (:known) ")
    List<Word> searchKnownWordCards(int known);
    @Query("select * from word " +
            "where card_known = (:known) " +
            "LIMIT (:cardLimit)")
    List<Word> searchKnownWordCards(int known, int cardLimit);

    //=========Grammar Card Search===================
    @Query("select * from grammar " +
            "where card_mastered = (:mastered) ")
    List<Grammar> searchMasteredGrammarCards(int mastered);
    @Query("select * from grammar " +
            "where card_mastered = (:mastered) " +
            "LIMIT (:cardLimit)")
    List<Grammar> searchMasteredGrammarCards(int mastered, int cardLimit);


    @Query("select * from grammar " +
            "where card_starred = (:starred)")
    List<Grammar> searchStarredGrammarCards(int starred);
    @Query("select * from grammar " +
            "where card_starred = (:starred) " +
            "LIMIT (:cardLimit)")
    List<Grammar> searchStarredGrammarCards(int starred, int cardLimit);


    @Query("select * from grammar " +
            "where card_known = (:known)")
    List<Grammar> searchKnownGrammarCards(int known);
    @Query("select * from grammar " +
            "where card_known = (:known) " +
            "LIMIT (:cardLimit)")
    List<Grammar> searchKnownGrammarCards(int known, int cardLimit);
}
