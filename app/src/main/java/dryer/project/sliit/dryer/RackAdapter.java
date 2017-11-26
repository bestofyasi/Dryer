package dryer.project.sliit.dryer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class RackAdapter extends ArrayAdapter<Rack> {

    ArrayList<Rack> racklist = new ArrayList<>();

    public RackAdapter(Context context, ArrayList<Rack> racks) {
        super(context, 0, racks);
    }

    public RackAdapter(Context context, int textViewResourceId, ArrayList<Rack> objects) {
        super(context, textViewResourceId, objects);
        racklist = objects;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.item_rack, null);
        TextView id = (TextView) v.findViewById(R.id.id);
//        final TextView rackid = (TextView) v.findViewById(R.id.rackid);
//        TextView ratio = (TextView) v.findViewById(R.id.ratio);
//
        id.setText("Rack " + Integer.toString(racklist.get(position).getId()));
//
//        rackid.setText(racklist.get(position).getRack_id());
//
//
//        ratio.setText(racklist.get(position).getRatio());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//            Toast.makeText(getContext(),rackid.getText(),Toast.LENGTH_SHORT).show();
                Intent next = new Intent(getContext(),Activity_OneRack.class);
                next.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                next.putExtra("rack_id",rackid.getText().toString());
                next.putExtra("index",Integer.toString(position));


                getContext().startActivity(next);
//                getContext().startActivity(new Intent(getContext(),Activity_OneRack.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        return v;

    }
}
