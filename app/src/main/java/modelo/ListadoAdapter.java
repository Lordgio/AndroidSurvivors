package modelo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

import survivors.com.androidsurvivors2.R;


public class ListadoAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<Participante> datos;
    private LayoutInflater lf;

    public ListadoAdapter(Context ctx, ArrayList<Participante> datos){
        this.ctx=ctx;
        this.datos=datos;
        lf=LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Generamos un objeto View a partit de la plantilla creada para la fila.
        convertView=lf.inflate(R.layout.tarjeta_participante,null);
        //Nombre
        TextView tvNombre=(TextView)convertView.findViewById(R.id.tv_nombre_participante);
        tvNombre.setText(datos.get(position).getNombre());
        //Descripcion
        TextView tvDescripcion=(TextView)convertView.findViewById(R.id.tv_Descr_part);
        tvDescripcion.setText(datos.get(position).getDescripcion());

        ImageButton linkedin=(ImageButton)convertView.findViewById(R.id.linkedinButton);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/in/"+datos.get(position).getLinkedin()));
                ctx.startActivity(intent);
                System.out.println("onClick completado!!!!");
            }
        });

        Button añadir=(Button)convertView.findViewById(R.id.añadirButton);
        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(datos.get(position).toString());
                System.out.println(datos.get(position).getTelefono());
                Intent intent=new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.NAME,datos.get(position).getNombre());
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,String.valueOf(datos.get(position).getTelefono()));
                intent.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MAIN);
                intent.putExtra(ContactsContract.Intents.Insert.EMAIL,datos.get(position).getEmail());
                intent.putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK);
                ctx.startActivity(intent);
            }
        });
        //Devolver el view de la fila
        return convertView;
    }
}
