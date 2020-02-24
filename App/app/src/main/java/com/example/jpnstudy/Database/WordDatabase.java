package com.example.jpnstudy.Database;

import android.content.Context;

import androidx.room.Room;

import com.example.jpnstudy.AsyncTasks.DeleteWord;
import com.example.jpnstudy.AsyncTasks.DeleteWordAll;
import com.example.jpnstudy.AsyncTasks.InsertWord;
import com.example.jpnstudy.AsyncTasks.SearchWordEnglish;
import com.example.jpnstudy.AsyncTasks.SearchWordJapanese;
import com.example.jpnstudy.AsyncTasks.SearchWordKanji;
import com.example.jpnstudy.AsyncTasks.SearchWordKnown;
import com.example.jpnstudy.AsyncTasks.SearchWordMastered;
import com.example.jpnstudy.AsyncTasks.SearchWordStarred;
import com.example.jpnstudy.AsyncTasks.SearchWordType;
import com.example.jpnstudy.Entities.Word;

import java.util.ArrayList;


public class WordDatabase {
    private FlashCardDatabase db;

    public WordDatabase(Context context){
        db = Room.databaseBuilder(context.getApplicationContext(), FlashCardDatabase.class, "word").build();
    }

    public void insertWord(Word word){
        InsertWord insertWord = new InsertWord(db);
        insertWord.execute(word);
    }

    public void deleteWord(Word word){
        DeleteWord deleteWord = new DeleteWord(db);
        deleteWord.execute(word);
    }

    public void deleteAllWords() {
        DeleteWordAll deleteWordAll = new DeleteWordAll(db);
        deleteWordAll.execute();
    }

    public ArrayList<Word> searchEnglish(String search){
        SearchWordEnglish searchWordEnglish = new SearchWordEnglish(db, search);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordEnglish.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchJapanese(String search){
        SearchWordJapanese searchWordJapanese = new SearchWordJapanese(db, search);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordJapanese.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchKanji(String search){
        SearchWordKanji searchWordKanji = new SearchWordKanji(db, search);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordKanji.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchType(String search){
        SearchWordType searchWordType = new SearchWordType(db, search);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordType.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchKnown(int bool){
        SearchWordKnown searchWordKnown  = new SearchWordKnown (db, bool);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordKnown.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchKnown(int bool, int limit){
        SearchWordKnown searchWordKnown  = new SearchWordKnown (db, bool, limit);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordKnown.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchMastered(int bool){
        SearchWordMastered searchWordMastered  = new SearchWordMastered (db, bool);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordMastered.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchMastered(int bool, int limit){
        SearchWordKnown searchWordMastered  = new SearchWordKnown (db, bool, limit);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordMastered.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchStarred(int bool){
        SearchWordStarred searchWordStarred  = new SearchWordStarred(db, bool);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordStarred.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }

    public ArrayList<Word> searchStarred(int bool, int limit){
        SearchWordStarred searchWordStarred  = new SearchWordStarred(db, bool, limit);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordStarred.execute().get();
        }
        catch (Exception e)
        {
            //do nothing
        }
        return rtnval;
    }














}
