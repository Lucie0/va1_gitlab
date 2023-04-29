package cz.mendelu.pef.test1.database;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import cz.mendelu.pef.test1.model.Word;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WordsDao_Impl implements WordsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Word> __insertionAdapterOfWord;

  public WordsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWord = new EntityInsertionAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `words` (`cz_word`,`en_word`,`id`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        if (value.getCz_word() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCz_word());
        }
        if (value.getEn_word() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEn_word());
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final Word word, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfWord.insertAndReturnId(word);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Word>> getAll() {
    final String _sql = "SELECT * FROM words";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"words"}, new Callable<List<Word>>() {
      @Override
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCzWord = CursorUtil.getColumnIndexOrThrow(_cursor, "cz_word");
          final int _cursorIndexOfEnWord = CursorUtil.getColumnIndexOrThrow(_cursor, "en_word");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Word _item;
            final String _tmpCz_word;
            if (_cursor.isNull(_cursorIndexOfCzWord)) {
              _tmpCz_word = null;
            } else {
              _tmpCz_word = _cursor.getString(_cursorIndexOfCzWord);
            }
            final String _tmpEn_word;
            if (_cursor.isNull(_cursorIndexOfEnWord)) {
              _tmpEn_word = null;
            } else {
              _tmpEn_word = _cursor.getString(_cursorIndexOfEnWord);
            }
            _item = new Word(_tmpCz_word,_tmpEn_word);
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
