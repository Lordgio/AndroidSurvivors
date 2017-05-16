package survivors.com.androidsurvivors2;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class TemarioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temario);

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
        } /*else if (id == R.id.noticias) {
            Intent intent_noticias = new Intent(this, NoticiasActivity.class);
            this.startActivity(intent_noticias);
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
