package com.android.td2.td2_android;
//macha@chillcoding.com
import android.content.Context;
import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Damien on 17/01/2017.
 */

public class GalleryAndroidActivity extends android.app.Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
// appel de la méthode initiale d’une Activity
//assure le fonctionnement normal de l’application
        super.onCreate(savedInstanceState);
// initialisation de la vue avec gallery.xml
        setContentView(R.layout.gallery);
// récupération de l’objet graphique gallery contenu
// dans gallery.xml
        Gallery g = (Gallery) findViewById(R.id.gallery);
// initialisation de l’objet gallery avec un ’adapter’
// ImageAdapter à créer (voir suite)
        g.setAdapter(new ImageAdapter(this));
// implémentation de la méthode de click
// sur un élément de ImageAdapter
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v,
                                    int position, long id) {
                Toast.makeText(GalleryAndroidActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;
        private Integer[] mImageIds = {R.drawable.donut, R.drawable.eclair, R.drawable.lollipop,
                R.drawable.nougat, R.drawable.cupcake, R.drawable.marshmallow};

        private ImageAdapter(Context c) {
            mContext = c;
            TypedArray a = mContext.obtainStyledAttributes(R.styleable.GalleryAndroid);
            mGalleryItemBackground = a.getResourceId(R.styleable.GalleryAndroid_android_galleryItemBackground, 0);
            a.recycle();
        }

        public int getCount() {
            return mImageIds.length;
        }
        public Object getItem(int position) {
            return position;
        }
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);
            i.setImageResource(mImageIds[position]);
            i.setLayoutParams(new Gallery.LayoutParams(150, 170));
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            i.setBackgroundResource(mGalleryItemBackground);
            return i;
        }
    }
}


