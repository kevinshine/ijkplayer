package tv.danmaku.ijk.media.sample.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import tv.danmaku.ijk.media.sample.R;
import tv.danmaku.ijk.media.sample.activities.MainActivity;
import tv.danmaku.ijk.media.sample.activities.VideoActivity;
import tv.danmaku.ijk.media.sample.content.MediaBean;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 */
public class PlaylistFragment extends Fragment {
    public static final String TAG = PlaylistFragment.class.getSimpleName();
    private ArrayAdapter<MediaBean> mAdapter;

    public static PlaylistFragment newInstance() {
        PlaylistFragment fragment = new PlaylistFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlaylistFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, MainActivity.PLAYLIST_ITEMS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist,
                container, false);

        Button removeAll = (Button)view.findViewById(R.id.btn_remove_all);
        removeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.PLAYLIST_ITEMS.clear();
                mAdapter.clear();
                mAdapter.notifyDataSetChanged();
            }
        });

        ListView playlist = (ListView)view.findViewById(R.id.list_playlist);
        playlist.setAdapter(mAdapter);
        playlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaBean bean = MainActivity.PLAYLIST_ITEMS.get(position);
                VideoActivity.intentTo(getActivity(),bean.path,bean.fileName);
            }
        });
        return view;
    }

}
