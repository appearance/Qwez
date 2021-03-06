package com.example.qwez.repository.sharedpref;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * SharedPrefences interface
 */
public interface SharedPreferencesRepositoryType {

    Single<Boolean> getNotFirstTime();

    Completable setNotFirstTime(boolean setTo);

    Single<Boolean> isRemembered();

    Single<String> getRemembered();

    Completable setRemembered(String toRemember);

    Completable setNotRemember();

    Completable setIsRemember(boolean remember);

}
