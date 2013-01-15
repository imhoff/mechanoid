package com.robotoworks.mechanoid.sqlite.generator;

import com.robotoworks.mechanoid.common.util.Strings;
import com.robotoworks.mechanoid.sqlite.generator.Extensions;
import com.robotoworks.mechanoid.sqlite.sqliteModel.ActionStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CreateTableStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.CreateViewStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DDLStatement;
import com.robotoworks.mechanoid.sqlite.sqliteModel.DatabaseBlock;
import com.robotoworks.mechanoid.sqlite.sqliteModel.Model;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ContentProviderActionGenerator {
  protected CharSequence _generate(final Model model, final CreateTableStatement tbl, final boolean forId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Generated by Robotoworks Mechanoid");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package ");
    String _packageName = model.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import android.content.ContentValues;");
    _builder.newLine();
    _builder.append("import android.database.sqlite.SQLiteDatabase;");
    _builder.newLine();
    _builder.append("import android.database.Cursor;");
    _builder.newLine();
    _builder.append("import android.net.Uri;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.content.ContentProviderActions;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.content.MechanoidContentProvider;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.sqlite.SQuery;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.sqlite.ActiveRecord;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.util.Closeables;");
    _builder.newLine();
    _builder.newLine();
    {
      boolean _hasAndroidPrimaryKey = Extensions.hasAndroidPrimaryKey(tbl);
      if (_hasAndroidPrimaryKey) {
        _builder.append("import ");
        String _packageName_1 = model.getPackageName();
        _builder.append(_packageName_1, "");
        _builder.append(".");
        String _name = tbl.getName();
        String _pascalize = Strings.pascalize(_name);
        _builder.append(_pascalize, "");
        _builder.append("Record;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("import ");
    String _packageName_2 = model.getPackageName();
    _builder.append(_packageName_2, "");
    _builder.append(".Abstract");
    DatabaseBlock _database = model.getDatabase();
    String _name_1 = _database.getName();
    String _pascalize_1 = Strings.pascalize(_name_1);
    _builder.append(_pascalize_1, "");
    _builder.append("OpenHelper.Tables;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _packageName_3 = model.getPackageName();
    _builder.append(_packageName_3, "");
    _builder.append(".");
    DatabaseBlock _database_1 = model.getDatabase();
    String _name_2 = _database_1.getName();
    String _pascalize_2 = Strings.pascalize(_name_2);
    _builder.append(_pascalize_2, "");
    _builder.append("Contract.");
    String _name_3 = tbl.getName();
    String _pascalize_3 = Strings.pascalize(_name_3);
    _builder.append(_pascalize_3, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("public abstract class Abstract");
    String _name_4 = tbl.getName();
    String _pascalize_4 = Strings.pascalize(_name_4);
    _builder.append(_pascalize_4, "");
    {
      if (forId) {
        _builder.append("ById");
      }
    }
    _builder.append("Actions extends ContentProviderActions {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int delete(MechanoidContentProvider provider, Uri uri, String selection, String[] selectionArgs){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      if (forId) {
        {
          boolean _hasAndroidPrimaryKey_1 = Extensions.hasAndroidPrimaryKey(tbl);
          if (_hasAndroidPrimaryKey_1) {
            _builder.append("\t\t");
            _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("int affected = SQuery.newQuery()");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append(".expr(");
            String _name_5 = tbl.getName();
            String _pascalize_5 = Strings.pascalize(_name_5);
            _builder.append(_pascalize_5, "		");
            _builder.append("._ID, SQuery.Op.EQ, uri.getPathSegments().get(1))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append(".append(selection, selectionArgs)");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append(".delete(db, Tables.");
            String _name_6 = tbl.getName();
            String _underscore = Strings.underscore(_name_6);
            String _upperCase = _underscore.toUpperCase();
            _builder.append(_upperCase, "		");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("return affected;");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("return -1; // TODO: throw exception?!");
            _builder.newLine();
          }
        }
      } else {
        _builder.append("\t\t");
        _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return db.delete(Tables.");
        String _name_7 = tbl.getName();
        String _underscore_1 = Strings.underscore(_name_7);
        String _upperCase_1 = _underscore_1.toUpperCase();
        _builder.append(_upperCase_1, "		");
        _builder.append(", selection, selectionArgs);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Uri insert(MechanoidContentProvider provider, Uri uri, ContentValues values){");
    _builder.newLine();
    {
      if (forId) {
        _builder.append("\t\t");
        _builder.append("return null; // Cannot insert on _id");
        _builder.newLine();
      } else {
        _builder.append("\t\t");
        _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("long id = db.insertOrThrow(Tables.");
        String _name_8 = tbl.getName();
        String _underscore_2 = Strings.underscore(_name_8);
        String _upperCase_2 = _underscore_2.toUpperCase();
        _builder.append(_upperCase_2, "		");
        _builder.append(", null, values);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if(id > -1) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return ");
        String _name_9 = tbl.getName();
        String _pascalize_6 = Strings.pascalize(_name_9);
        _builder.append(_pascalize_6, "			");
        _builder.append(".buildUriWithId(id);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int update(MechanoidContentProvider provider, Uri uri, ContentValues values, String selection, String[] selectionArgs){");
    _builder.newLine();
    {
      if (forId) {
        {
          boolean _hasAndroidPrimaryKey_2 = Extensions.hasAndroidPrimaryKey(tbl);
          if (_hasAndroidPrimaryKey_2) {
            _builder.append("\t\t");
            _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("int affected = SQuery.newQuery()");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append(".expr(");
            String _name_10 = tbl.getName();
            String _pascalize_7 = Strings.pascalize(_name_10);
            _builder.append(_pascalize_7, "		");
            _builder.append("._ID, SQuery.Op.EQ, uri.getPathSegments().get(1))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append(".append(selection, selectionArgs)");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append(".update(db, Tables.");
            String _name_11 = tbl.getName();
            String _underscore_3 = Strings.underscore(_name_11);
            String _upperCase_3 = _underscore_3.toUpperCase();
            _builder.append(_upperCase_3, "		");
            _builder.append(", values);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("return affected;");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("return -1; // TODO: throw exception?!");
            _builder.newLine();
          }
        }
      } else {
        _builder.append("\t\t");
        _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("int affected = db.update(Tables.");
        String _name_12 = tbl.getName();
        String _underscore_4 = Strings.underscore(_name_12);
        String _upperCase_4 = _underscore_4.toUpperCase();
        _builder.append(_upperCase_4, "		");
        _builder.append(", values, selection, selectionArgs);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return affected;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Cursor query(MechanoidContentProvider provider, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder){");
    _builder.newLine();
    {
      if (forId) {
        {
          boolean _hasAndroidPrimaryKey_3 = Extensions.hasAndroidPrimaryKey(tbl);
          if (_hasAndroidPrimaryKey_3) {
            _builder.append("\t\t");
            _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("return SQuery.newQuery()");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append(".expr(");
            String _name_13 = tbl.getName();
            String _pascalize_8 = Strings.pascalize(_name_13);
            _builder.append(_pascalize_8, "		");
            _builder.append("._ID, SQuery.Op.EQ, uri.getPathSegments().get(1))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append(".append(selection, selectionArgs)");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append(".query(db, Tables.");
            String _name_14 = tbl.getName();
            String _underscore_5 = Strings.underscore(_name_14);
            String _upperCase_5 = _underscore_5.toUpperCase();
            _builder.append(_upperCase_5, "		");
            _builder.append(", projection, sortOrder);");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t");
            _builder.append("return null; // TODO: throw exception?!");
            _builder.newLine();
          }
        }
      } else {
        _builder.append("\t\t");
        _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return db.query(Tables.");
        String _name_15 = tbl.getName();
        String _underscore_6 = Strings.underscore(_name_15);
        String _upperCase_6 = _underscore_6.toUpperCase();
        _builder.append(_upperCase_6, "		");
        _builder.append(", projection, selection, selectionArgs, null, null, sortOrder);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public int bulkInsert(MechanoidContentProvider provider, Uri uri, ContentValues[] values) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("int numValues = values.length;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("\t    \t");
    _builder.append("db.beginTransaction();");
    _builder.newLine();
    _builder.append("\t    \t");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("for (int i = 0; i < numValues; i++) {");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.append("db.insertOrThrow(Tables.");
    String _name_16 = tbl.getName();
    String _underscore_7 = Strings.underscore(_name_16);
    String _upperCase_7 = _underscore_7.toUpperCase();
    _builder.append(_upperCase_7, "	        	");
    _builder.append(", null, values[i]);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("db.setTransactionSuccessful();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("db.endTransaction();");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return numValues;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    {
      boolean _hasAndroidPrimaryKey_4 = Extensions.hasAndroidPrimaryKey(tbl);
      if (_hasAndroidPrimaryKey_4) {
        _builder.append("\t");
        _builder.append("@SuppressWarnings(\"unchecked\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public <T extends ActiveRecord> List<T> selectRecords(MechanoidContentProvider provider, Uri uri, SQuery sQuery, String sortOrder) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Cursor c = null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("ArrayList<T> items = new ArrayList<T>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("c = db.query(Tables.");
        String _name_17 = tbl.getName();
        String _underscore_8 = Strings.underscore(_name_17);
        String _upperCase_8 = _underscore_8.toUpperCase();
        _builder.append(_upperCase_8, "			");
        _builder.append(", ");
        String _name_18 = tbl.getName();
        String _pascalize_9 = Strings.pascalize(_name_18);
        _builder.append(_pascalize_9, "			");
        _builder.append("Record.PROJECTION, sQuery.toString(), sQuery.getArgsArray(), null, null, sortOrder);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t    ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t    ");
        _builder.append("while(c.moveToNext()) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t        ");
        _builder.append("items.add((T)");
        String _name_19 = tbl.getName();
        String _pascalize_10 = Strings.pascalize(_name_19);
        _builder.append(_pascalize_10, "		        ");
        _builder.append("Record.fromCursor(c));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("        ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("} finally {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("        ");
        _builder.append("Closeables.closeSilently(c);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("return items;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generate(final Model model, final CreateViewStatement vw, final boolean forId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Generated by Robotoworks Mechanoid");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package ");
    String _packageName = model.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import android.content.ContentValues;");
    _builder.newLine();
    _builder.append("import android.content.ContentProvider;");
    _builder.newLine();
    _builder.append("import android.database.Cursor;");
    _builder.newLine();
    _builder.append("import android.database.sqlite.SQLiteDatabase;");
    _builder.newLine();
    _builder.append("import android.net.Uri;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.content.ContentProviderActions;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.sqlite.SQuery;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.content.MechanoidContentProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import ");
    String _packageName_1 = model.getPackageName();
    _builder.append(_packageName_1, "");
    _builder.append(".Abstract");
    DatabaseBlock _database = model.getDatabase();
    String _name = _database.getName();
    String _pascalize = Strings.pascalize(_name);
    _builder.append(_pascalize, "");
    _builder.append("OpenHelper.Tables;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _packageName_2 = model.getPackageName();
    _builder.append(_packageName_2, "");
    _builder.append(".");
    DatabaseBlock _database_1 = model.getDatabase();
    String _name_1 = _database_1.getName();
    String _pascalize_1 = Strings.pascalize(_name_1);
    _builder.append(_pascalize_1, "");
    _builder.append("Contract.");
    String _name_2 = vw.getName();
    String _pascalize_2 = Strings.pascalize(_name_2);
    _builder.append(_pascalize_2, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("public abstract class Abstract");
    String _name_3 = vw.getName();
    String _pascalize_3 = Strings.pascalize(_name_3);
    _builder.append(_pascalize_3, "");
    {
      if (forId) {
        _builder.append("ById");
      }
    }
    _builder.append("Actions extends ContentProviderActions {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int delete(MechanoidContentProvider provider, Uri uri, String selection, String[] selectionArgs){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return -1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Uri insert(MechanoidContentProvider provider, Uri uri, ContentValues values){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int update(MechanoidContentProvider provider, Uri uri, ContentValues values, String selection, String[] selectionArgs){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return -1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Cursor query(MechanoidContentProvider provider, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder){");
    _builder.newLine();
    {
      if (forId) {
        {
          boolean _hasAndroidPrimaryKey = Extensions.hasAndroidPrimaryKey(vw);
          if (_hasAndroidPrimaryKey) {
            _builder.append("\t\t");
            _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("return SQuery.newQuery()");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append(".expr(");
            String _name_4 = vw.getName();
            String _pascalize_4 = Strings.pascalize(_name_4);
            _builder.append(_pascalize_4, "		");
            _builder.append("._ID, SQuery.Op.EQ, uri.getPathSegments().get(1))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append(".append(selection, selectionArgs)");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append(".query(db, Tables.");
            String _name_5 = vw.getName();
            String _underscore = Strings.underscore(_name_5);
            String _upperCase = _underscore.toUpperCase();
            _builder.append(_upperCase, "		");
            _builder.append(", projection, sortOrder);");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t");
            _builder.append("return null; // TODO: throw exception?!");
            _builder.newLine();
          }
        }
      } else {
        _builder.append("\t\t");
        _builder.append("final SQLiteDatabase db = provider.getOpenHelper().getWritableDatabase();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return db.query(Tables.");
        String _name_6 = vw.getName();
        String _underscore_1 = Strings.underscore(_name_6);
        String _upperCase_1 = _underscore_1.toUpperCase();
        _builder.append(_upperCase_1, "		");
        _builder.append(", projection, selection, selectionArgs, null, null, sortOrder);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate(final Model model, final ActionStatement action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Generated by Robotoworks Mechanoid");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package ");
    String _packageName = model.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.content.ContentProviderActions;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("public abstract class Abstract");
    String _name = action.getName();
    String _pascalize = Strings.pascalize(_name);
    _builder.append(_pascalize, "");
    _builder.append("Actions extends ContentProviderActions {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateStub(final Model model, final CreateTableStatement tbl, final boolean forId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Generated by Robotoworks Mechanoid");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package ");
    String _packageName = model.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _name = tbl.getName();
    String _pascalize = Strings.pascalize(_name);
    _builder.append(_pascalize, "");
    {
      if (forId) {
        _builder.append("ById");
      }
    }
    _builder.append("Actions extends Abstract");
    String _name_1 = tbl.getName();
    String _pascalize_1 = Strings.pascalize(_name_1);
    _builder.append(_pascalize_1, "");
    {
      if (forId) {
        _builder.append("ById");
      }
    }
    _builder.append("Actions {}");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _generateStub(final Model model, final CreateViewStatement vw, final boolean forId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Generated by Robotoworks Mechanoid");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package ");
    String _packageName = model.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _name = vw.getName();
    String _pascalize = Strings.pascalize(_name);
    _builder.append(_pascalize, "");
    {
      if (forId) {
        _builder.append("ById");
      }
    }
    _builder.append("Actions extends Abstract");
    String _name_1 = vw.getName();
    String _pascalize_1 = Strings.pascalize(_name_1);
    _builder.append(_pascalize_1, "");
    {
      if (forId) {
        _builder.append("ById");
      }
    }
    _builder.append("Actions {}");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateStub(final Model model, final ActionStatement action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Generated by Robotoworks Mechanoid");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package ");
    String _packageName = model.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _name = action.getName();
    String _pascalize = Strings.pascalize(_name);
    _builder.append(_pascalize, "");
    _builder.append("Actions extends Abstract");
    String _name_1 = action.getName();
    String _pascalize_1 = Strings.pascalize(_name_1);
    _builder.append(_pascalize_1, "");
    _builder.append("Actions {}");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generate(final Model model, final DDLStatement tbl, final boolean forId) {
    if (tbl instanceof CreateTableStatement) {
      return _generate(model, (CreateTableStatement)tbl, forId);
    } else if (tbl instanceof CreateViewStatement) {
      return _generate(model, (CreateViewStatement)tbl, forId);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model, tbl, forId).toString());
    }
  }
  
  public CharSequence generateStub(final Model model, final DDLStatement tbl, final boolean forId) {
    if (tbl instanceof CreateTableStatement) {
      return _generateStub(model, (CreateTableStatement)tbl, forId);
    } else if (tbl instanceof CreateViewStatement) {
      return _generateStub(model, (CreateViewStatement)tbl, forId);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model, tbl, forId).toString());
    }
  }
}