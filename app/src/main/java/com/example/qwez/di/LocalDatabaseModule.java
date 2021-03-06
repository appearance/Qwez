package com.example.qwez.di;

import android.content.Context;

import androidx.room.Room;

import com.example.qwez.repository.local.GameDatabase;
import com.example.qwez.repository.local.GameRepository;
import com.example.qwez.repository.local.GameRepositoryType;
import com.example.qwez.repository.local.dao.GameDao;
import com.example.qwez.repository.local.dao.GameQuestionDao;
import com.example.qwez.repository.local.dao.QuestionDao;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalDatabaseModule {

    /**
     * Get GameRepository. Singleton
     * @param gameDao Dagger provided
     * @param questionDao Dagger provided
     * @param gameQuestionDao Dagger provided
     * @return GameRepository
     */
    @Provides
    @ApplicationScope
    GameRepositoryType gameRepositoryType(GameDao gameDao,
                                          QuestionDao questionDao,
                                          GameQuestionDao gameQuestionDao,
                                          GameDatabase gameDatabase){
        return new GameRepository(gameDao, questionDao,gameQuestionDao, gameDatabase);
    }

    /**
     * Get GameQuestionDao. Singleton
     * @param gameDatabase Dagger provided
     * @return GameQuestionDao
     */
    @Provides
    @ApplicationScope
    GameQuestionDao gameQuestionDao(GameDatabase gameDatabase){
        return gameDatabase.gameQuestionDao();
    }

    /**
     * Get QuestionDao. Singleton
     * @param gameDatabase Dagger provided
     * @return QuestionDao
     */
    @Provides
    @ApplicationScope
    QuestionDao questionDao(GameDatabase gameDatabase){
        return gameDatabase.questionDao();
    }

    /**
     * Get GameDao. Singleton
     * @param gameDatabase Dagger provided
     * @return GameDao
     */
    @Provides
    @ApplicationScope
    GameDao gameDao(GameDatabase gameDatabase){
        return gameDatabase.gameDao();
    }

    /**
     * Get GameDatabase. Singleton
     * @param context Dagger provided
     * @return GameDatabase
     */
    @Provides
    @ApplicationScope
    GameDatabase gameDatabase(Context context){
        return Room
                .databaseBuilder(context, GameDatabase.class, GameDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

}
