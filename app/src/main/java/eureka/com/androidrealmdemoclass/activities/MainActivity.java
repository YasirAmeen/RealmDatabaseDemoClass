package eureka.com.androidrealmdemoclass.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import eureka.com.androidrealmdemoclass.R;
import eureka.com.androidrealmdemoclass.model.Profile;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {


    TextView _tv;
    ImageView _iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm realm = Realm.getDefaultInstance();


        _iv = (ImageView) findViewById(R.id.imageView);
        Glide.with(this)
                .load("http://yasirameen.com/wp-content/uploads/2016/09/Android-Realm-Database-1024x471.jpg")
                .crossFade()
                .into(_iv);

       /* realm.beginTransaction();
        Profile profile = realm.createObject(Profile.class);
        profile.setId(3);
        profile.setFirstname("Adeel");
        profile.setLastname("Nazar");
        profile.setEmail("adeelNazar@gmail.com");
        profile.setAddress("Karachi, Pakistan");
        realm.commitTransaction();

        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
*/

       /* _tv = (TextView) findViewById(R.id.name);
        Profile _profile = realm.where(Profile.class).equalTo("email","YasirAmeen92@gmail.com").findFirst();

        String fname = _profile.getFirstname();
        String lname = _profile.getLastname();

        _tv.setText("fullname : "+fname +" "+lname);
        _tv.setTextSize(24f);
*/


       RealmResults<Profile> profileres = realm.where(Profile.class).findAll();
        for(Profile result : profileres) {

            Toast.makeText(this, "name " + result.getFirstname() + " " +result.getLastname(), Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(this, "fullname : "+fname +" "+lname, Toast.LENGTH_SHORT).show();





    }
}
