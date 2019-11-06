package com.example.database_helper.model;

public class BaseRepository {

    private static BaseRepository mInstance;

    private final AppDatabase mDatabase;

    public BaseRepository(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    public synchronized static BaseRepository getInstance(final AppDatabase database){
        if (mInstance == null){
            mInstance = new BaseRepository(database);
        }
        return mInstance;
    }


}
