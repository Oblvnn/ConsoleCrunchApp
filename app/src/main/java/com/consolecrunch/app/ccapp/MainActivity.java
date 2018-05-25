package com.consolecrunch.app.ccapp;

import android.content.Intent;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        WebView cweb = (WebView)findViewById(R.id.ccweb);
        cweb.getSettings().setJavaScriptEnabled(true);
        cweb.setWebViewClient(new WebViewClient());
        cweb.loadUrl("https://consolecrunch.com");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        WebView cweb = (WebView)findViewById(R.id.ccweb);
        cweb.getSettings().setJavaScriptEnabled(true);
        cweb.setWebViewClient(new WebViewClient());

        if (id == R.id.nav_home) {
            cweb.loadUrl("https://consolecrunch.com");
        } else if (id == R.id.nav_chat) {
            cweb.loadUrl("https://consolecrunch.com/chat/");
        } else if (id == R.id.nav_form) {
            cweb.loadUrl("https://consolecrunch.com/forums/");
        } else if (id == R.id.nav_memb) {
            cweb.loadUrl("https://consolecrunch.com/members/");
        } else if (id == R.id.nav_set) {
            cweb.loadUrl("https://consolecrunch.com/account/");
        } else if (id == R.id.nav_inbox) {
            cweb.loadUrl("https://consolecrunch.com/conversations/");
        } else if (id == R.id.nav_alt) {
            cweb.loadUrl("https://consolecrunch.com/account/alerts");
        } else if (id == R.id.nav_github) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/OblivionSan"));
            startActivity(browserIntent);
        } else if (id == R.id.nav_twitter) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/OblivionSan"));
            startActivity(browserIntent);
        } else if (id == R.id.nav_web) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://oblivionsan.tk"));
            startActivity(browserIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
