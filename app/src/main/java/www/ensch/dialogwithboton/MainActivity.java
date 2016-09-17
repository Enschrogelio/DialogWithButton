package www.ensch.dialogwithboton;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView) findViewById(R.id.textView);
        Button boton= (Button) findViewById(R.id.button1);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showDialog(0);
    }


    @Override
    protected Dialog onCreateDialog(int id){

        DListener listener= new DListener();
        Dialog dialogo=null;
        if(id==0){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder=builder.setIcon(R.mipmap.ic_launcher);
            builder=builder.setIcon(R.mipmap.ic_launcher);
            builder=builder.setTitle("Dialog with buttons");
            builder=builder.setMessage("message. " +
                    "\n Bla Bla Bla");
            builder=builder.setPositiveButton("Botton +", listener);
            builder=builder.setNegativeButton("Botton -", listener);
            builder=builder.setNeutralButton("Botton N", listener);
            dialogo=builder.create();
        }
        return dialogo;
    }

    class DListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE)
                tv.setText("Pressed: Botton +");
            if(which == DialogInterface.BUTTON_NEGATIVE)
                tv.setText("Pressed: -");
            if(which == DialogInterface.BUTTON_NEUTRAL)
                tv.setText("Pressed: N");
        }
    }  // end DialogInterface.OnClickListener

}