package com.demo.db_room.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.db_room.Interface.Listener;
import com.demo.db_room.Modelo.Usuario;
import com.demo.db_room.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context context;
    List<Usuario> usuarioList;
    Listener listener;

    public UserAdapter(Context context, List<Usuario> usuarioList, Listener listener) {
        this.context = context;
        this.usuarioList = usuarioList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_info_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_id.setText(String.valueOf(usuarioList.get(position).getId()));
        holder.txt_name.setText(usuarioList.get(position).getNombre());
        holder.txt_mail.setText(usuarioList.get(position).getMail());
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txt_id, txt_name, txt_mail;
        CardView btn_edit, btn_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_mail = itemView.findViewById(R.id.txt_mail);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            btn_delete = itemView.findViewById(R.id.btn_delete);

            btn_edit.setOnClickListener(this);
            btn_delete.setOnClickListener(this);
        }

        /**
         * Conecto el click de cada botón con la vista por medio de una interfaz, ya que uso la
         * posición del ítem para obtener el id con el que esta almacenado el objeto en la base de
         * datos.
         * @param view
         */
        @Override
        public void onClick(View view) {
            int id = usuarioList.get(getAdapterPosition()).getId();
            if (view.getId() == btn_edit.getId()) {
                listener.editUser(id, getAdapterPosition());
            } else {
                listener.deleteUser(id);
            }
        }
    }
}
