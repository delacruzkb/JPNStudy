package com.example.jpnstudy.Database;

import android.content.Context;

import androidx.room.Room;

import com.example.jpnstudy.AsyncTasks.DeleteWord;
import com.example.jpnstudy.AsyncTasks.DeleteWordAll;
import com.example.jpnstudy.AsyncTasks.InsertWord;
import com.example.jpnstudy.AsyncTasks.InsertWordList;
import com.example.jpnstudy.AsyncTasks.SearchWordEnglish;
import com.example.jpnstudy.AsyncTasks.SearchWordHiragana;
import com.example.jpnstudy.AsyncTasks.SearchWordKanji;
import com.example.jpnstudy.AsyncTasks.SearchWordKnown;
import com.example.jpnstudy.AsyncTasks.SearchWordMastered;
import com.example.jpnstudy.AsyncTasks.SearchWordStarred;
import com.example.jpnstudy.AsyncTasks.SearchWordType;
import com.example.jpnstudy.Entities.Word;

import java.util.ArrayList;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.FileReader;

public class WordDatabase {
    private FlashCardDatabase db;

    public WordDatabase(Context context){
        db = Room.databaseBuilder(context.getApplicationContext(), FlashCardDatabase.class, "word").build();
    }

    public void revertDefault()
    {
        deleteAllWords();

        try {
            ArrayList<Word> wordList= new ArrayList<>();
            Word word;
            CSVReader reader = new CSVReader(new FileReader("jpns(words).csv"));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                //hiragana,english,kanji,type
                word = new Word();
                word.setHiragana(nextLine[0]);
                word.setEnglish(nextLine[1]);
                if(nextLine[2].equals("null"))
                {
                    word.setKanji(null);
                }
                else
                {
                    word.setKanji(nextLine[2]);
                }
                word.setType(nextLine[3]);
                wordList.add(word);
            }
            InsertWordList insertWordList = new InsertWordList(db);
            insertWordList.execute(wordList);
        } catch (IOException e) {

        }
    }

    public void insertWord(Word word){
        InsertWord insertWord = new InsertWord(db);
        insertWord.execute(word);
    }

    public void insertWordList(ArrayList<Word> list){
        InsertWordList insertWordList = new InsertWordList(db);
        insertWordList.execute(list);
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

    public ArrayList<Word> searchHiragana(String search){
        SearchWordHiragana searchWordHiragana = new SearchWordHiragana(db, search);
        ArrayList<Word> rtnval=null;
        try{
            rtnval= searchWordHiragana.execute().get();
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
