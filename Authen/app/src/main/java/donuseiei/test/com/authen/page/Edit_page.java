package donuseiei.test.com.authen.page;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.io.FileNotFoundException;
import java.io.IOException;

import donuseiei.test.com.authen.CloudListActivity;
import donuseiei.test.com.authen.HTTPConnector;
import donuseiei.test.com.authen.Profile;
import donuseiei.test.com.authen.R;

public class Edit_page extends AppCompatActivity {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "password";

    // TODO: Rename and change types of parameters
    private String id;
    private String password;
    private RequestParams params;
    private Bundle bundle;
    private EditText edit_name;
    private EditText edit_email;
    private EditText edit_password;
    private RequestParams paramsName = new RequestParams();
    private RequestParams paramsEmail = new RequestParams();
    private RequestParams paramsPass = new RequestParams();
    public static final int GET_FROM_GALLERY = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_edit_page);
        bundle = getIntent().getExtras().getBundle("idPassCloudProvIP");
        if (bundle != null) {
            id = bundle.getString("id");
            password = bundle.getString("password");
            params = new RequestParams();
            params.put("password", password);
        }
        Button submit = (Button)findViewById(R.id.save_edit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paramsName.put("password", password);
                paramsEmail.put("password", password);
                paramsPass.put("password", password);
                paramsName.put("name", edit_name.getText().toString());
                paramsEmail.put("newemail", edit_email.getText().toString());
                paramsPass.put("newpassword", edit_password.getText().toString());
                updateProfileEmail(paramsEmail);
            }
        });
        Button cancel = (Button)findViewById(R.id.cancel_edit);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit_page.this,Profile_page.class);
                intent.putExtra("idPassCloudProvIP",bundle);
                startActivity(intent);
            }
        });
        edit_email = (EditText)findViewById(R.id.edit_email);
        edit_name = (EditText)findViewById(R.id.edit_fullname);
        edit_password = (EditText)findViewById(R.id.edit_pass);
    }
    public void updateProfileName(RequestParams params){
        HTTPConnector.get("update/name/"+id+"/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                updateProfilePassword(paramsPass);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(Edit_page.this, "Name : Error Code " + statusCode, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void updateProfileEmail(RequestParams params){
        HTTPConnector.get("update/email/"+id+"/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                updateProfileName(paramsName);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(Edit_page.this, "Email : Error Code " + statusCode, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void updateProfilePassword(RequestParams params){
        HTTPConnector.get("update/password/" + id + "/", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Intent intent = new Intent(Edit_page.this, Profile_page.class);
                intent.putExtra("idPassCloudProvIP", bundle);
                startActivity(intent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(Edit_page.this, "Password : Error Code " + statusCode, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.main_home:
                Intent intent = new Intent(this,CloudListActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("password",password);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
