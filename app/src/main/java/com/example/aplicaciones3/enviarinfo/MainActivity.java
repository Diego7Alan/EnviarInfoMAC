package com.example.aplicaciones3.enviarinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btn;
    TextView txt;
    EditText edt;
    String URL = "http://nuevo.rnrsiilge-org.mx/nombre";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnenviar).setOnClickListener(this);
        txt = findViewById(R.id.txtrecibir);
        edt = findViewById(R.id.edtxenviar);

    }


    @Override
    public void onClick(View v)
    {

     JSONObject n = new JSONObject();

        try
        {
            n.put("Nombre", edt.getText().toString());
            //n.put("Nombre", "Adolfo");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }


        JsonObjectRequest js = new JsonObjectRequest(
                Request.Method.POST,
                URL,
                n,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        txt.setText(response.toString());
                    }
                },


                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(),"ESTAS MECO",Toast.LENGTH_SHORT).show();
                    }
                }

        );
        Volleys.getInstance(this).getmRequestQueue().add(js);


    }
    }
