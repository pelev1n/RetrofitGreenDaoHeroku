package com.andrewxa.a4retrofitcrud;

import android.app.Application;

import com.andrewxa.a4retrofitcrud.bd.DaoMaster;
import com.andrewxa.a4retrofitcrud.bd.DaoSession;

import org.greenrobot.greendao.database.Database;


public class App extends Application {
   private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"greendao_books.db");
        Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

   public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
