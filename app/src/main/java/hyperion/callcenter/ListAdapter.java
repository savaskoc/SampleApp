package hyperion.callcenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by savaskoc on 18/09/2016.
 */
public class ListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Center> list;

    public ListAdapter(Context context, List<Center> list) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Center getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.view_center, null);
            convertView.setTag(new VH(convertView));
        }
        ((VH) convertView.getTag()).bind(getItem(position));
        return convertView;
    }

    public static class VH {
        private ImageView image;
        private TextView text;

        public VH(View view) {
            this.image = (ImageView) view.findViewById(R.id.image);
            this.text = (TextView) view.findViewById(R.id.text);
        }

        public void bind(Center center) {
            Picasso.with(image.getContext()).load(center.image).into(image);
            text.setText(center.name);
        }
    }
}