package steven.puxin.com.imagepickerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.ui.ImageGridActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_SELECT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button choosebtn = findViewById(R.id.choosebtn);
        choosebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showDialog();
                ImagePicker.getInstance().setSelectLimit(1);
                Intent intent1 = new Intent(MainActivity.this, ImageGridActivity.class);
                startActivityForResult(intent1, REQUEST_CODE_SELECT);

//                ImagePicker.getInstance().setSelectLimit(1);
//                Intent intent = new Intent(MainActivity.this, ImageGridActivity.class);
//                intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true);
//                startActivityForResult(intent, REQUEST_CODE_SELECT);


            }
        });



    }

    private void showDialog() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(false);                      //显示拍照按钮
        imagePicker.setCrop(false);                           //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(false);                   //是否按矩形区域保存
        imagePicker.setMultiMode(false);
        imagePicker.setSelectLimit(1);              //选中数量限制
//        imagePicker.setStyle(CropImageView.Style.CIRCLE);  //裁剪框的形状
//        imagePicker.setFocusWidth(DensityUtil.dp2px(300));                       //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
//        imagePicker.setFocusHeight(DensityUtil.dp2px(300));                      //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(500);                         //保存文件的宽度。单位像素
        imagePicker.setOutPutY(500);                         //保存文件的高度。单位像素
//        List<String> names = new ArrayList<>();
//        names.add("拍照");
//        names.add("相册");
//        SelectDialog dialog = new SelectDialog(this, mListener, names);
//        dialog.show();
    }


}
