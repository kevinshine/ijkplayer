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

    private MediaBean mPlayingItem = null;

    private PlaylistManager() {
    }

    public static PlaylistManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlaylistManager();
        }

        return INSTANCE;
    }

    public void addAll(List<MediaBean> list) {
        mList.addAll(list);
    }

    public void addItem(MediaBean bean) {
        mList.add(bean);
    }

    public void clear() {
        mList.clear();
    }

    public List<MediaBean> getPlaylist() {
        return mList;
    }

    public MediaBean getItem(int position){
        MediaBean result = null;

        if (position > -1 && position < mList.size())
            result = mList.get(position);

        return result;
    }

    public void setPlayingItem(MediaBean bean){
        this.mPlayingItem = bean;
    }

    public MediaBean getPlayingItem(){
        return mPlayingItem;
    }

    public MediaBean next(MediaBean bean) {
        MediaBean result = null;
        int index = mList.indexOf(bean);
        if (index > -1 && index < mList.size()-1) {
            result = mList.get(index + 1);
        }

        return result;
    }

    public MediaBean previous(MediaBean bean){
        MediaBean result = null;
        int index = mList.indexOf(bean);
        if (index > 0 && index < mList.size()) {
            result = mList.get(index - 1);
        }

        return result;
    }
}
