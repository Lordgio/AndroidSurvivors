package survivors.com.androidsurvivors2;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.GestionParticipantes;
import modelo.Participante;

public class ObjetivoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GestionParticipantes gp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivo);

        gp=new GestionParticipantes(this);
        if(gp.comprobarParticipantes()!=10){
            AñadirParticipantes añadir=new AñadirParticipantes();
            añadir.execute();
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
            // Handle the camera action
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

    class AñadirParticipantes extends AsyncTask<Void,Void,ArrayList<Participante>>{
        @Override
        protected void onPostExecute(ArrayList<Participante> parts) {
            //gp.eliminarTodos();
            for(int i=0;i<parts.size();i++){
                gp.altaParticipante(parts.get(i));
            }
        }

        @Override
        protected ArrayList<Participante> doInBackground(Void... params) {
            InputStream fichero=getResources().openRawResource(R.raw.participantes);
            BufferedReader bf=new BufferedReader(new InputStreamReader(fichero));
            String s;
            ArrayList<Participante> parts=new ArrayList<>();
            try {
                while ((s = bf.readLine())!=null) {
                    String[] datos = s.split("[|]");
                    Participante p = new Participante(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
                    parts.add(p);
                }
            }catch(IOException ex) {
                ex.printStackTrace();
            }
            return parts;
        }
    }
}
