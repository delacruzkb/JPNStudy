package com.example.jpnstudy.Database;

import android.content.Context;
import android.widget.ProgressBar;

import androidx.room.Room;

import com.example.jpnstudy.AsyncTasks.DeleteFlashCard;
import com.example.jpnstudy.AsyncTasks.InsertFlashCard;
import com.example.jpnstudy.AsyncTasks.InsertFlashCardList;
import com.example.jpnstudy.AsyncTasks.LoadDefaultDatabase;
import com.example.jpnstudy.AsyncTasks.SearchFlashCardEnglish;
import com.example.jpnstudy.AsyncTasks.SearchFlashCardHiragana;
import com.example.jpnstudy.AsyncTasks.SearchFlashCardKanji;
import com.example.jpnstudy.AsyncTasks.SearchFlashCardKnown;
import com.example.jpnstudy.AsyncTasks.SearchFlashCardMastered;
import com.example.jpnstudy.AsyncTasks.SearchFlashCardStarred;
import com.example.jpnstudy.AsyncTasks.SearchFlashCardType;
import com.example.jpnstudy.Entities.FlashCard;

import java.util.ArrayList;

public class FlashCardDatabaseReader {
    FlashCardDatabase db;
    Context context;
    public FlashCardDatabaseReader(Context context){
        this.context = context;
        db = Room.databaseBuilder(context.getApplicationContext(), FlashCardDatabase.class, "flashcard").build();
    }

    public void deleteFlashCard(FlashCard flashCard){
        DeleteFlashCard deleteFlashCard = new DeleteFlashCard(db);
        deleteFlashCard.execute(flashCard);
    }

    public void insertFlashCard(FlashCard flashCard){
        InsertFlashCard insertFlashCard = new InsertFlashCard(db);
        insertFlashCard.execute(flashCard);
    }

    public void insertFlashCardList(ArrayList<FlashCard> flashCards){
        InsertFlashCardList insertFlashCardList = new InsertFlashCardList(db);
        insertFlashCardList.execute(flashCards);
    }

    public ArrayList<FlashCard> searchFlashCardEnglish(String input){
        SearchFlashCardEnglish search = new SearchFlashCardEnglish(db);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute(input).get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardHiragana(String input){
        SearchFlashCardHiragana search = new SearchFlashCardHiragana(db);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute(input).get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardKanji(String input){
        SearchFlashCardKanji search = new SearchFlashCardKanji(db);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute(input).get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardType(String input){
        SearchFlashCardType search = new SearchFlashCardType(db);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute(input).get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardKnown(boolean input){
        SearchFlashCardKnown search = new SearchFlashCardKnown(db, input);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute().get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardKnown(boolean input, int limit) {
        SearchFlashCardKnown search = new SearchFlashCardKnown(db, input ,limit);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute().get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardMastered(boolean input){
        SearchFlashCardMastered search = new SearchFlashCardMastered(db, input);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute().get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardMastered(boolean input, int limit) {
        SearchFlashCardMastered search = new SearchFlashCardMastered(db, input ,limit);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute().get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardStarred(boolean input){
        SearchFlashCardStarred search = new SearchFlashCardStarred(db, input);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute().get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public ArrayList<FlashCard> searchFlashCardStarred(boolean input, int limit) {
        SearchFlashCardStarred search = new SearchFlashCardStarred(db, input ,limit);
        ArrayList<FlashCard> flashCards=new ArrayList<>();
        try
        {
            flashCards = search.execute().get();
        }
        catch (Exception e)
        {

        }

        return flashCards;
    }

    public void loadDefaultDatabase(ArrayList<FlashCard> cards, ProgressBar loadingBar) {
        LoadDefaultDatabase loader = new LoadDefaultDatabase(db, context,loadingBar);
        loader.execute(cards);
    }

}
