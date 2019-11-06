package com.example.database_helper.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.database_helper.model.dao.PersonDao;
import com.example.database_helper.model.entity.Person;
import com.tencent.wcdb.room.db.WCDBOpenHelperFactory;

@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase mInstance;

    public static final String DB_PATH = "";

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static synchronized AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (mInstance == null) {
            mInstance = buildDatabase(context.getApplicationContext(), executors);
            mInstance.updateDatabaseCreated(context.getApplicationContext());
        }
        return mInstance;
    }

    private static AppDatabase buildDatabase(final Context appContext, final AppExecutors executors) {
        WCDBOpenHelperFactory factory = new WCDBOpenHelperFactory()
                .writeAheadLoggingEnabled(true) //打开WAL以及读写并发，可以省略让Room决定是否打开
                .asyncCheckpointEnabled(true);  //打开异步Checkpoint优化，不需要可以省略

        return Room.databaseBuilder(appContext, AppDatabase.class, DB_PATH)
                .openHelperFactory(factory)
                .addCallback(new Callback() {
                    private void run() {
                    }

                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIo().execute(this::run);
                    }
                })
                .addMigrations(MIGRATION_1_2)
                .build();
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DB_PATH).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true);
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

    public abstract PersonDao getPersonDao();
}
