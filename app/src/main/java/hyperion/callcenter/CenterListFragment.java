package hyperion.callcenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * Created by savaskoc on 18/09/2016.
 */
public class CenterListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_center_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setToolbar("Call Centers", false);

        ListView list = (ListView) view.findViewById(R.id.list);
        if (adapter == null)
            adapter = new ListAdapter(getContext(), Center.LIST);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((MainActivity) getActivity()).changeFragment(CenterDetailFragment.withCenter(adapter.getItem(position)));
    }
}