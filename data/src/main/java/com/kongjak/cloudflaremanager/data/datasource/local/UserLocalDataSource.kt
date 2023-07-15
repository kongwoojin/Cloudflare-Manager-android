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
    private val userEmail = stringPreferencesKey("user_email")
    private val userAPIKey = stringPreferencesKey("user_api_key")

    suspend fun setUserEmail(email: String) {
        context.dataStore.edit { user ->
            user[userEmail] = email
        }
    }

    fun getUserEmail(): Flow<String> {
        return context.dataStore.data
            .catch{ exception ->
                if(exception is IOException){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }.map{
                it[userEmail] ?: ""
            }
    }

    suspend fun setUserAPIKey(apiKey: String) {
        context.dataStore.edit { user ->
            user[userAPIKey] = apiKey
        }
    }

    fun getUserAPIKey(): Flow<String> {
        return context.dataStore.data
            .catch{ exception ->
                if(exception is IOException){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }.map{
                it[userAPIKey] ?: ""
            }
    }
}