// Generated by view binder compiler. Do not edit!
package com.kbulab.exam.sqliteexam.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kbulab.exam.sqliteexam.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySqlinsertBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnBackMain;

  @NonNull
  public final Button btnInsert;

  @NonNull
  public final EditText textInsertAddress;

  @NonNull
  public final EditText textInsertAge;

  @NonNull
  public final EditText textInsertName;

  @NonNull
  public final TextView textViewLog;

  private ActivitySqlinsertBinding(@NonNull LinearLayout rootView, @NonNull Button btnBackMain,
      @NonNull Button btnInsert, @NonNull EditText textInsertAddress,
      @NonNull EditText textInsertAge, @NonNull EditText textInsertName,
      @NonNull TextView textViewLog) {
    this.rootView = rootView;
    this.btnBackMain = btnBackMain;
    this.btnInsert = btnInsert;
    this.textInsertAddress = textInsertAddress;
    this.textInsertAge = textInsertAge;
    this.textInsertName = textInsertName;
    this.textViewLog = textViewLog;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySqlinsertBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySqlinsertBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sqlinsert, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySqlinsertBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_back_main;
      Button btnBackMain = ViewBindings.findChildViewById(rootView, id);
      if (btnBackMain == null) {
        break missingId;
      }

      id = R.id.btn_insert;
      Button btnInsert = ViewBindings.findChildViewById(rootView, id);
      if (btnInsert == null) {
        break missingId;
      }

      id = R.id.text_insert_address;
      EditText textInsertAddress = ViewBindings.findChildViewById(rootView, id);
      if (textInsertAddress == null) {
        break missingId;
      }

      id = R.id.text_insert_age;
      EditText textInsertAge = ViewBindings.findChildViewById(rootView, id);
      if (textInsertAge == null) {
        break missingId;
      }

      id = R.id.text_insert_name;
      EditText textInsertName = ViewBindings.findChildViewById(rootView, id);
      if (textInsertName == null) {
        break missingId;
      }

      id = R.id.text_view_log;
      TextView textViewLog = ViewBindings.findChildViewById(rootView, id);
      if (textViewLog == null) {
        break missingId;
      }

      return new ActivitySqlinsertBinding((LinearLayout) rootView, btnBackMain, btnInsert,
          textInsertAddress, textInsertAge, textInsertName, textViewLog);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}