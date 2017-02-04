package view;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jason.loopviewpagerdemo.R;

import java.util.ArrayList;

import adapter.ImageAdapter;

public class MainActivity extends BaseActivity {
    private ViewPager viewPager;
    private ImageAdapter imageAdapter;
    private int FIRST_ITEM_INDEX;
    private int LAST_ITEM_INDEX;
    private int currentPos;
    private boolean isChanged;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.MainActivity_ViewPager);
    }

    @Override
    protected void initData() {
        int[] resIds=new int[]{R.drawable.img_one,R.drawable.img_two,R.drawable.img_three,R.drawable.img_four,R.drawable.img_five};
        ArrayList<ImageView> images=new ArrayList<>();
        initImages(images,resIds);
        imageAdapter=new ImageAdapter(this,images);
        viewPager.setAdapter(imageAdapter);
        viewPager.setCurrentItem(1);
        FIRST_ITEM_INDEX=1;
        LAST_ITEM_INDEX=images.size()-2;
    }

    @Override
    protected void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position>LAST_ITEM_INDEX){
                    isChanged=true;
                    currentPos=FIRST_ITEM_INDEX;
                }else if(position<FIRST_ITEM_INDEX){
                    isChanged=true;
                    currentPos=LAST_ITEM_INDEX;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(ViewPager.SCROLL_STATE_IDLE==state){
                    if(isChanged){
                        isChanged=false;
                        viewPager.setCurrentItem(currentPos,false);
                    }
                }
            }
        });
    }

    private void initImages(ArrayList<ImageView> images,int[] resIds){
        images.add(createImage(resIds[resIds.length-1]));
        for(int i=0;i<resIds.length;i++){
            images.add(createImage(resIds[i]));
        }
        images.add(createImage(resIds[0]));
    }

    private ImageView createImage(int resId){
        ImageView img=new ImageView(this);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(this)
                .load(resId)
                .dontAnimate()
                .into(img);
        return img;
    }
}
