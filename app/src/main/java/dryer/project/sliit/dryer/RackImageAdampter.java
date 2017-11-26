package dryer.project.sliit.dryer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;





public class RackImageAdampter extends ArrayAdapter<RackImage> {


    ArrayList<RackImage> imagelist = new ArrayList<>();

    public RackImageAdampter(Context context, ArrayList<RackImage> rackImages) {
        super(context, 0, rackImages);
    }

    public RackImageAdampter(Context context, int textViewResourceId, ArrayList<RackImage> objects) {
        super(context, textViewResourceId, objects);
        imagelist = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.one_rack_image, null);


        ImageView beforeImage = (ImageView)v.findViewById(R.id.image_one_rack_before);
        ImageView afterImage = (ImageView)v.findViewById(R.id.image_one_rack_after);

        Picasso.with(v.getContext()).load(Constants.BASE_URL + imagelist.get(position).getImageBefore()).into(beforeImage);
        Picasso.with(v.getContext()).load(Constants.BASE_URL + imagelist.get(position).getImageAfter()).into(afterImage);

        return v;

    }


}
