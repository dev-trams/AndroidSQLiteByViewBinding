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

public final class ActivitySqldeleteBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnBackMain;

  @NonNull
  public final Button btnDelete;

  @NonNull
  public final EditText textKeywordName;

  @NonNull
  public final TextView textViewAddress;

  @NonNull
  public final TextView textViewAge;

  @NonNull
  public final TextView viewQuery;

  private ActivitySqldeleteBinding(@NonNull LinearLayout rootView, @NonNull Button btnBackMain,
      @NonNull Button btnDelete, @NonNull EditText textKeywordName,
      @NonNull TextView textViewAddress, @NonNull TextView textViewAge,
      @NonNull TextView viewQuery) {
    this.rootView = rootView;
    this.btnBackMain = btnBackMain;
    this.btnDelete = btnDelete;
    this.textKeywordName = textKeywordName;
    this.textViewAddress = textViewAddress;
    this.textViewAge = textViewAge;
    this.viewQuery = viewQuery;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySqldeleteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySqldeleteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sqldelete, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySqldeleteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_back_main;
      Button btnBackMain = ViewBindings.findChildViewById(rootView, id);
      if (btnBackMain == null) {
        break missingId;
      }

      id = R.id.btn_delete;
      Button btnDelete = ViewBindings.findChildViewById(rootView, id);
      if (btnDelete == null) {
        break missingId;
      }

      id = R.id.text_keyword_name;
      EditText textKeywordName = ViewBindings.findChildViewById(rootView, id);
      if (textKeywordName == null) {
        break missingId;
      }

      id = R.id.text_view_address;
      TextView textViewAddress = ViewBindings.findChildViewById(rootView, id);
      if (textViewAddress == null) {
        break missingId;
      }

      id = R.id.text_view_age;
      TextView textViewAge = ViewBindings.findChildViewById(rootView, id);
      if (textViewAge == null) {
        break missingId;
      }

      id = R.id.view_query;
      TextView viewQuery = ViewBindings.findChildViewById(rootView, id);
      if (viewQuery == null) {
        break missingId;
      }

      return new ActivitySqldeleteBinding((LinearLayout) rootView, btnBackMain, btnDelete,
          textKeywordName, textViewAddress, textViewAge, viewQuery);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}