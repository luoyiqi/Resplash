package com.b_lam.resplash;

import android.app.Activity;
import android.app.Application;
import android.graphics.drawable.Drawable;

import com.b_lam.resplash.activities.MainActivity;
import com.b_lam.resplash.data.data.Collection;
import com.b_lam.resplash.data.data.Photo;
import com.b_lam.resplash.data.data.User;

import java.util.ArrayList;
import java.util.List;

import com.b_lam.resplash.BuildConfig;

/**
 * Created by Brandon on 10/6/2016.
 */

public class Resplash extends Application{

    private List<Activity> activityList;
    private Photo photo;
    private Collection collection;
    private User user;
    private Drawable drawable;
    private boolean myOwnCollection = false;
    private boolean activityInBackstage = false;

    // Unsplash data.
    public static final String APPLICATION_ID = BuildConfig.UNSPLASH_APPLICATION_ID;
    public static final String SECRET = BuildConfig.UNSPLASH_SECRET;

    // Unsplash url.
    public static final String UNSPLASH_API_BASE_URL = "https://api.unsplash.com/";
    public static final String UNSPLASH_URL = "https://unsplash.com/";
    public static final String UNSPLASH_UPLOAD_URL = "https://unsplash.com/submit";
    public static final String UNSPLASH_JOIN_URL = "https://unsplash.com/join";
    public static final String UNSPLASH_LOGIN_CALLBACK = "unsplash-auth-callback";
    public static final String UNSPLASH_LOGIN_URL = Resplash.UNSPLASH_URL + "oauth/authorize"
            + "?client_id=" + Resplash.APPLICATION_ID
            + "&redirect_uri=" + "resplash%3A%2F%2F" + UNSPLASH_LOGIN_CALLBACK
            + "&response_type=" + "code"
            + "&scope=" + "public+read_user+write_user+read_photos+write_photos+write_likes+read_collections+write_collections";

    public static final String DATE_FORMAT = "yyyy/MM/dd";

    public static final int DEFAULT_PER_PAGE = 30;
    public static final int SEARCH_PER_PAGE = 20;

    public static final int CATEGORY_TOTAL_NEW = 0;
    public static final int CATEGORY_TOTAL_FEATURED = 1;
    public static final int CATEGORY_BUILDINGS_ID = 2;
    public static final int CATEGORY_FOOD_DRINK_ID = 3;
    public static final int CATEGORY_NATURE_ID = 4;
    public static final int CATEGORY_OBJECTS_ID = 8;
    public static final int CATEGORY_PEOPLE_ID = 6;
    public static final int CATEGORY_TECHNOLOGY_ID = 7;

    public static int TOTAL_NEW_PHOTOS_COUNT = 14500;
    public static int TOTAL_FEATURED_PHOTOS_COUNT = 900;
    public static int BUILDING_PHOTOS_COUNT = 2720;
    public static int FOOD_DRINK_PHOTOS_COUNT = 650;
    public static int NATURE_PHOTOS_COUNT = 6910;
    public static int OBJECTS_PHOTOS_COUNT = 2150;
    public static int PEOPLE_PHOTOS_COUNT = 3410;
    public static int TECHNOLOGY_PHOTOS_COUNT = 350;

    // activity code.
    public static final int ME_ACTIVITY = 1;

    // permission code.
    public static final int WRITE_EXTERNAL_STORAGE = 1;

    /** <br> life cycle. */

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        instance = this;
        activityList = new ArrayList<>();
    }

    /** <br> data. */

    public void addActivity(Activity a) {
        activityList.add(a);
    }

    public void removeActivity() {
        activityList.remove(activityList.size() - 1);
    }
    /*
        public List<Activity> getActivityList() {
            return activityList;
        }
    */
    public Activity getLatestActivity() {
        if (activityList.size() > 0) {
            return activityList.get(activityList.size() - 1);
        } else {
            return null;
        }
    }

    public MainActivity getMainActivity() {
        if (activityList.get(0) instanceof MainActivity) {
            return (MainActivity) activityList.get(0);
        } else {
            return null;
        }
    }

    public int getActivityCount() {
        return activityList.size();
    }

    public void setPhoto(Photo p) {
        this.photo = p;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setCollection(Collection c) {
        this.collection = c;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setUser(User u) {
        this.user = u;
    }

    public User getUser() {
        return user;
    }

    public void setDrawable(Drawable d) {
        this.drawable = d;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setMyOwnCollection(boolean own) {
        this.myOwnCollection = own;
    }

    public boolean isMyOwnCollection() {
        return myOwnCollection;
    }

    public void setActivityInBackstage(boolean showing) {
        this.activityInBackstage = showing;
    }

    public boolean isActivityInBackstage() {
        return activityInBackstage;
    }

    /** <br> singleton. */

    private static Resplash instance;

    public static Resplash getInstance() {
        return instance;
    }

}
