package app.reservation.acbasoftare.com.reservation.App_Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import app.reservation.acbasoftare.com.reservation.Dialog.CreditCardDialog;
import app.reservation.acbasoftare.com.reservation.R;
import app.reservation.acbasoftare.com.reservation.WebTasks.WebService;

import static android.R.attr.name;

/**
 * Main display for customer. Self kiosk serve
 */
public class TicketScreenActivity extends AppCompatActivity {
    private WebService ws;
    private String TAG = "FIREBASE TAG::";
    private StorageReference mStorageRef;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_screen);
        this.ws = new WebService();
         database = FirebaseDatabase.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
// Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
    private void writeUserData(int userId, String name) {
        //database.getReference().
    }

    @Override
    public void onBackPressed(){
        Log.d("Back Press in Ticket","pressed");
    }
    private void showCreditCard(){
        CreditCardDialog ccd = new CreditCardDialog(this,ws);
        ccd.showCreditCardDialog(true);
    }
}
