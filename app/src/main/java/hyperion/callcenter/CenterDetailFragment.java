package hyperion.callcenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by savaskoc on 18/09/2016.
 */
public class CenterDetailFragment extends Fragment {
    private static final String KEY = "center";

    public static CenterDetailFragment withCenter(Center center) {
        Bundle args = new Bundle();
        args.putSerializable(KEY, center);

        CenterDetailFragment fragment = new CenterDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_center_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Center center = (Center) getArguments().getSerializable(KEY);
        ((MainActivity) getActivity()).setToolbar(center.name, true);
    }
}
