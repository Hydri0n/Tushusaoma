package cc.hydrion.tushusaoma.Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class FavoritesPageAdapter extends PagerAdapter {

    List<View> mViewList;

    public FavoritesPageAdapter(List<View> viewList){
        mViewList = viewList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }
}
