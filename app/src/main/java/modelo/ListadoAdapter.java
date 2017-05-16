package modelo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        //Generamos un objeto View a partir de la plantilla creada para la fila.
        convertView=lf.inflate(R.layout.tarjeta_participante,null);

        //Nombre
        TextView tvNombre=(TextView)convertView.findViewById(R.id.tv_nombre_participante);
        tvNombre.setText(datos.get(position).getNombre());

        //Descripcion
        TextView tvDescripcion=(TextView)convertView.findViewById(R.id.tv_Descr_part);
        tvDescripcion.setText(datos.get(position).getDescripcion());

        //Añadir foto de perfil
        ImageView foto=(ImageView)convertView.findViewById(R.id.fotoPerfil);
        String[]nombre=datos.get(position).getNombre().split("[ ]");
        System.out.println(nombre[0]);
        switch(nombre[0]){
            case "Adrian":
                //foto.setImageResource(R.drawable.foto_adrian);
                foto.setImageBitmap(
                        decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.foto_adrian, 100, 100));
                break;
            case "Alberto":
                //foto.setImageResource(R.drawable.foto_alberto);
                foto.setImageBitmap(
                        decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.foto_alberto, 100, 100));
                /*if(nombre[1].equals("")){
                    foto.setImageDrawable(R.drawable.fotoAlberto);
                }else{
                    foto.setImageDrawable(R.drawable.fotoAlberto);
                }*/
                break;
            case "David":
                //foto.setImageResource(R.drawable.foto_david);
                foto.setImageBitmap(
                        decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.foto_david, 100, 100));
                break;
            case "Deirdre":
                //foto.setImageResource(R.drawable.foto_deirdre);
                foto.setImageBitmap(
                        decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.foto_deirdre, 100, 100));
                break;
            case "Gonzalo":
                foto.setImageResource(R.drawable.ic_nosotros);
                break;
            case "Jorge":
                //foto.setImageResource(R.drawable.foto_jorge);
                foto.setImageBitmap(
                        decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.foto_jorge, 100, 100));
                break;
            case "Maria":
                //foto.setImageResource(R.drawable.foto_maria);
                foto.setImageBitmap(
                        decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.foto_maria, 100, 100));
                break;
            case "Sergio":
                //foto.setImageResource(R.drawable.foto_sergio);
                foto.setImageBitmap(
                        decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.foto_sergio, 100, 100));
                break;
            case "Silvia":
                //foto.setImageResource(R.drawable.foto_silvia);
                foto.setImageBitmap(
                        decodeSampledBitmapFromResource(ctx.getResources(), R.drawable.foto_silvia, 100, 100));
                break;
        }

        //Linkedin
        ImageButton linkedin=(ImageButton)convertView.findViewById(R.id.linkedinButton);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/in/"+datos.get(position).getLinkedin()));
                ctx.startActivity(intent);
            }
        });

        //Añadir como contacto
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

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
