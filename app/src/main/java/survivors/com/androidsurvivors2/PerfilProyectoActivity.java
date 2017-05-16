package survivors.com.androidsurvivors2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import modelo.GestionParticipantes;
import modelo.ListadoAdapter;
import modelo.Participante;
import modelo.Proyecto;

public class PerfilProyectoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GestionParticipantes gp;
    TextView nombre,descripcion;
    ListView participantes;
    ImageButton github;
    Proyecto p;
    ImageView perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_proyecto);

        nombre=(TextView)this.findViewById(R.id.nombreProyecto);
        descripcion=(TextView)this.findViewById(R.id.descripcionProyecto);
        participantes=(ListView)this.findViewById(R.id.listaPartsProyecto);
        github=(ImageButton)this.findViewById(R.id.githubProyecto);
        perfil=(ImageView)this.findViewById(R.id.iv_perfilProyecto);

        gp=new GestionParticipantes(this);
        //Recibir intent y buscar info en bbdd sobre ese proyecto
        Intent intent=this.getIntent();
        String proyecto=intent.getStringExtra("proyecto");
        p=gp.obtenerProyecto(proyecto);


        //Mostrar la info en los campos.
        nombre.setText(p.getNombre());
        descripcion.setText(p.getDescripcion());
        //Obtener información de los participantes de cada proyecto.
        ArrayList<Participante> parts=new ArrayList<>();
        if(p.getParticipante1().equals("null")){

        }else{
            Participante part=gp.obtenerParticipante(p.getParticipante1());
            parts.add(part);
        }
        if(p.getParticipante2().equals("null")){

        }else{
            Participante part=gp.obtenerParticipante(p.getParticipante2());
            parts.add(part);
        }
        if(p.getParticipante3().equals("null")){

        }else{
            Participante part=gp.obtenerParticipante(p.getParticipante3());
            parts.add(part);
        }
        //Añadir esa informacion a un ListView
        ListadoAdapter adapter=new ListadoAdapter(this,parts);
        participantes.setAdapter(adapter);

        //Seleccionar foto de perfil
        if(p.getNombre().equals("Blinder")){
            perfil.setImageBitmap(
                    decodeSampledBitmapFromResource(this.getResources(), R.drawable.blinderlogo, 110, 100));
        }else if(p.getNombre().equals("InfoWork")){
            perfil.setImageBitmap(
                    decodeSampledBitmapFromResource(this.getResources(), R.drawable.infoworklogo, 110, 100));
        }else if(p.getNombre().equals("Manitapp")){
            perfil.setImageBitmap(
                    decodeSampledBitmapFromResource(this.getResources(), R.drawable.manitapplogo, 110, 100));
        }else if(p.getNombre().equals("RepairToday")){
            perfil.setImageBitmap(
                    decodeSampledBitmapFromResource(this.getResources(), R.drawable.repairlogo, 110, 100));
        }else if(p.getNombre().equals("LaborDay")){

        }else if(p.getNombre().equals("AndroidSurvivor")){
            perfil.setImageBitmap(
                    decodeSampledBitmapFromResource(this.getResources(), R.mipmap.bottle, 110, 100));
        }

        //Creación del menu lateral
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        drawer.setScrimColor(Color.TRANSPARENT);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void github(View v){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.github.com/"+p.getGithub()));
        this.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.objetivos) {
            Intent intent_objetivo=new Intent(this,ObjetivoActivity.class);
            this.startActivity(intent_objetivo);
        } else if (id == R.id.temario) {
            Intent intent_temario = new Intent(this, TemarioActivity.class);
            this.startActivity(intent_temario);
        } else if (id == R.id.profesor) {
            Intent intent_profesor=new Intent(this,ProfesorActivity.class);
            this.startActivity(intent_profesor);
        } else if (id == R.id.empresas) {
            Intent intent_empresas=new Intent(this,EmpresasActivity.class);
            this.startActivity(intent_empresas);
        } else if (id == R.id.nosotros) {
            Intent intent_nosotros = new Intent(this, ParticipantesActivity.class);
            this.startActivity(intent_nosotros);
        } else if (id == R.id.proyectos) {
            Intent intent_proyectos = new Intent(this, ProyectosActivity.class);
            this.startActivity(intent_proyectos);
        } /*else if (id == R.id.noticias) {
            Intent intent_noticias = new Intent(this, NoticiasActivity.class);
            this.startActivity(intent_noticias);
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
