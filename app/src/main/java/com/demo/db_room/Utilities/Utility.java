package com.demo.db_room.Utilities;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.db_room.Modelo.Usuario;
import com.demo.db_room.R;

public class Utility {

    public static Dialog dialogEditUser(Context c, int resId, Usuario ref) {
        Dialog dialog = new Dialog(c, R.style.AlertDialog_AppCompat);
        dialog.setContentView(resId);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));

        //Bind
        EditText input_new_name = dialog.findViewById(R.id.input_new_name);
        EditText input_new_age = dialog.findViewById(R.id.input_new_age);
        EditText input_new_mail = dialog.findViewById(R.id.input_new_mail);
        EditText input_new_phone = dialog.findViewById(R.id.input_new_phone);

        //Set info Usuario
        input_new_name.setText(ref.getNombre());
        input_new_age.setText(String.valueOf(ref.getEdad()));
        input_new_mail.setText(ref.getMail());
        input_new_phone.setText(ref.getTel());

        //Cursor
        input_new_name.setSelection(ref.getNombre().length());
        input_new_age.setSelection(String.valueOf(ref.getEdad()).length());
        input_new_mail.setSelection(ref.getMail().length());
        input_new_phone.setSelection(ref.getTel().length());

        dialog.setCancelable(false);
        dialog.create();
        dialog.show();

        return dialog;
    }

    public static Dialog centeSmallDialog(Context c, int resId, Usuario ref) {
        Dialog dialog = new Dialog(c, R.style.AlertDialog_AppCompat);
        dialog.setContentView(resId);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));

        //Bind
        TextView label_desc = dialog.findViewById(R.id.label_desc);

        //Set info Usuario
        label_desc.setText("¿Está seguro que desea eliminar a " + ref.getNombre() + "?");

        dialog.setCancelable(false);
        dialog.create();
        dialog.show();

        return dialog;
    }
}
