package com.kongjak.cloudflaremanager.data.datasource.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")
    private val userToken = stringPreferencesKey("user_token")

    suspend fun setUserToken(token: String) {
        context.dataStore.edit { user ->
            user[userToken] = token
        }
    }

    fun getUserToken(): Flow<String> {
        return context.dataStore.data
            .catch{ exception ->
                if(exception is IOException){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }.map{
                it[userToken] ?: ""
            }
    }
}