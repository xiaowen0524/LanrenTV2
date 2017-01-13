package lanren.com.lanrentv2.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by asus on 2016/11/9.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public void init() {
        ImageLoader imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
        imageLoader.init(builder.build());
    }
}
