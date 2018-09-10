package com.example.latte.ec.database;

import android.content.Context;

import com.example.latte_core.activities.ProxyActivity;

import org.greenrobot.greendao.database.Database;


public class DataBaseManager {

    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private DataBaseManager(){

    }

    public DataBaseManager init(Context context){
        initDao(context);
        return this;
    }

    public static DataBaseManager getInstance(){
        return Holder.INSTRANCE;
    }

    private static final class Holder{
        private static final DataBaseManager INSTRANCE = new DataBaseManager();
    }

    private void initDao(Context context){

        try {
            final ReleaseOpenHelper helper = new ReleaseOpenHelper(context,"fast_ec.ab");
            final Database db = helper.getWritableDb();
            mDaoSession = new DaoMaster(db).newSession();
            mDao = mDaoSession.getUserProfileDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final UserProfileDao getDao(){
        return mDao;
    }
}
