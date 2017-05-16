package survivors.com.androidsurvivors2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ProyectosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CardView blinder,infowork,manitapp,repairtoday,other,android;
    TextView app1,app2,app3,app4,app5,app6;
    ImageView iapp1,iapp2,iapp3,iapp4,iapp5,iapp6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);

        app1=(TextView)this.findViewById(R.id.nombreApp1);
        app2=(TextView)this.findViewById(R.id.nombreApp2);
        app3=(TextView)this.findViewById(R.id.nombreApp3);
        app4=(TextView)this.findViewById(R.id.nombreApp4);
        app5=(TextView)this.findViewById(R.id.nombreApp5);
        app6=(TextView)this.findViewById(R.id.nombreApp6);

        iapp1=(ImageView)this.findViewById(R.id.iv_app1);
        iapp1.setImageBitmap(
                decodeSampledBitmapFromResource(this.getResources(), R.drawable.blinderlogo, 100, 100));
        iapp2=(ImageView)this.findViewById(R.id.iv_app2);
        iapp2.setImageBitmap(
                decodeSampledBitmapFromResource(this.getResources(), R.drawable.infoworklogo, 100, 100));
        iapp2=(ImageView)this.findViewById(R.id.iv_app2);
        iapp3=(ImageView)this.findViewById(R.id.iv_app3);
        iapp3.setImageBitmap(
                decodeSampledBitmapFromResource(this.getResources(), R.drawable.manitapplogo, 100, 100));
        iapp4=(ImageView)this.findViewById(R.id.iv_app4);
        iapp4.setImageBitmap(
                decodeSampledBitmapFromResource(this.getResources(), R.drawable.repairlogo, 100, 100));
        iapp5=(ImageView)this.findViewById(R.id.iv_app5);
        iapp6=(ImageView)this.findViewById(R.id.iv_app6);
        iapp6.setImageBitmap(
                decodeSampledBitmapFromResource(this.getResources(), R.mipmap.bottle, 100, 100));

        blinder=(CardView)this.findViewById(R.id.blinder);
        blinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProyectosActivity.this,PerfilProyectoActivity.class);
                intent.putExtra("proyecto",app1.getText().toString());
                ProyectosActivity.this.startActivity(intent);
            }
        });
        infowork=(CardView)this.findViewById(R.id.infowork);
        infowork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProyectosActivity.this,PerfilProyectoActivity.class);
                intent.putExtra("proyecto",app2.getText().toString());
                ProyectosActivity.this.startActivity(intent);
            }
        });
        manitapp=(CardView)this.findViewById(R.id.manitapp);
        manitapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProyectosActivity.this,PerfilProyectoActivity.class);
                intent.putExtra("proyecto",app3.getText().toString());
                ProyectosActivity.this.startActivity(intent);
            }
        });
        repairtoday=(CardView)this.findViewById(R.id.repairtoday);
        repairtoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProyectosActivity.this,PerfilProyectoActivity.class);
                intent.putExtra("proyecto",app4.getText().toString());
                ProyectosActivity.this.startActivity(intent);
            }
        });
        other=(CardView)this.findViewById(R.id.laborday);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProyectosActivity.this,PerfilProyectoActivity.class);
                intent.putExtra("proyecto",app5.getText().toString());
                ProyectosActivity.this.startActivity(intent);
            }
        });
        android=(CardView)this.findViewById(R.id.android);
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProyectosActivity.this,PerfilProyectoActivity.class);
                intent.putExtra("proyecto",app6.getText().toString());
                ProyectosActivity.this.startActivity(intent);
            }
        });

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
        } else if (id == R.id.noticias) {
            Intent intent_noticias = new Intent(this, NoticiasActivity.class);
            this.startActivity(intent_noticias);
        }

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
