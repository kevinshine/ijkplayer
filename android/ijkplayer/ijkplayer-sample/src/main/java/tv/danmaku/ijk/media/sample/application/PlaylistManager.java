package tv.danmaku.ijk.media.sample.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

import tv.danmaku.ijk.media.sample.content.MediaBean;

/**
 * Created by shenchuan on 15-11-9.
 */
public class PlaylistManager {
    private List<MediaBean> mList = Collections.synchronizedList(new ArrayList<MediaBean>());
    private static PlaylistManager INSTANCE = null;

    private PlaylistManager(){
    }

    public static PlaylistManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PlaylistManager();
        }

        return INSTANCE;
    }

    public void addAll(List<MediaBean> list){
        mList.addAll(list);
    }

    public void addItem(MediaBean bean){
        mList.add(bean);
    }

    public void clear(){
        mList.clear();
    }

    public List<MediaBean> getPlaylist(){
        return mList;
    }
}
