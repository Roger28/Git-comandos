package com.example.android.gitcomandos.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.android.gitcomandos.DataGenerator;
import com.example.android.gitcomandos.db.dao.ComandoDao;
import com.example.android.gitcomandos.db.entity.Comando;

/**
 *  Terceira classe a ser criada
 *  Esta classe abstrata utiliza um padrão singleton (gera um único objeto). Ela que cria o banco.
 *  Sempre usar anotação @Database e passar as suas tabelas (classes objetos), a versão do banco
 *  e último paramêtro false.
 **/

@Database(entities = {Comando.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    /**
     * Reservado para futuras implementações, mantenha comentado...
     **/

//    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();


//    public static AppDataBase getInstance(final Context context, AppExecutors executors){
//        if(instance == null){
//            synchronized (AppDataBase.class){
//                if(instance == null){
//                    instance = buildDatabase(context.getApplicationContext(), executors);
//                    instance.updateDatabaseCreated(context.getApplicationContext());
//                }
//            }
//        }
//        return instance;
//    }
//
//    /**
//     * Build the database. {@link Builder#build()} only sets up the database configuration and
//     * creates a new instance of the database.
//     * The SQLite database is only created when it's accessed for the first time.
//     */
//    private static AppDataBase buildDatabase(final Context appContext, final AppExecutors executors){
//        return Room.databaseBuilder(appContext, AppDataBase.class, DATABASE_NAME)
//                .addCallback(new Callback() {
//                    @Override
//                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
//                        super.onCreate(db);
//                        executors.diskIO().execute(() -> {
//                            // Add a delay to simulate a long-running operation
//                            addDelay();
//                            // Generate the data for pre-population
//                            AppDataBase dataBase = AppDataBase.getInstance(appContext, executors);
//                            List<Comando> comandos = DataGenerator.generateCommandos();
//                            insertData(dataBase, comandos);
//                            // notify that the database was created and it's ready to be used
//                            dataBase.setDatabaseCreated();
//                        });
//                    }
//                })
//                .addMigrations(MIGRATION_1_2)
//                .build();
//    }
//
//    private void updateDatabaseCreated(final Context context) {
//        if (context.getDatabasePath(DATABASE_NAME).exists()) {
//            setDatabaseCreated();
//        }
//    }
//
//    private void setDatabaseCreated(){
//        mIsDatabaseCreated.postValue(true);
//    }
//
//    private static void insertData(final AppDataBase database, final List<Comando> comandos) {
//        database.runInTransaction(() -> {
//            database.comandoDao().insert(comandos);
//        });
//    }
//
//    private static void addDelay() {
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException ignored) {
//        }
//    }
//
//    public LiveData<Boolean> getDatabaseCreated() {
//        return mIsDatabaseCreated;
//    }

    private static AppDataBase instance;

    private static final String DATABASE_NAME = "git_database";

    public abstract ComandoDao comandoDao();

    public static synchronized AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .addMigrations(FROM_1_TO_2)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static final Migration FROM_1_TO_2 = new Migration(1, 2) {

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `comandos`(" +
                    "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "`conteudo` TEXT, " +
                    "`descricao` TEXT)");

            database.execSQL("INSERT INTO comandos (`id`, `conteudo`, `descricao`) "
                    + "SELECT `id`, `conteudo`, `descricao` FROM comandos");

        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private ComandoDao comandoDao;

        private PopulateDbAsyncTask(AppDataBase db) {
            this.comandoDao = db.comandoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // aqui insere os dados no banco

            this.comandoDao.insert(DataGenerator.generateCommandos());
            return null;
        }
    }
}
