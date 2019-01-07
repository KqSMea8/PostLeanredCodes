package com.fengjianghui.personal.baseanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void imageViewClick(View view) {
        Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_SHORT).show();
    }


    public void buttonClick(View view){

//        //传统动画的实现方法
//        TranslateAnimation animation = new TranslateAnimation(0, 200, 0, 0);
//        //动画持续时长
//        animation.setDuration(1000);
//        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.startAnimation(animation);
//        animation.setFillAfter(true);

//        //属性动画的实现方法一
//        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        //这三个方法是同时实现的，相当于是异步方法
//        ObjectAnimator.ofFloat(imageView,"translationX",0F,200F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"translationY",0F,360F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F).setDuration(1000).start();

//        //属性动画实现方法二
//        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        PropertyValuesHolder holder=PropertyValuesHolder.ofFloat("translationX",0f,200F);
//        PropertyValuesHolder holder1=PropertyValuesHolder.ofFloat("translationY",0f,200F);
//        PropertyValuesHolder holder2=PropertyValuesHolder.ofFloat("rotation",0f,360F);
//        ObjectAnimator.ofPropertyValuesHolder(imageView, holder, holder1, holder2).setDuration(1000).start();

        //属性动画实现方法三
        //用animatorSet实现的话可控性更强，可以设置三个一起动，还可以按顺序一个一个动作一个动作来
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 200F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 200F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);
        AnimatorSet animatorSet=new AnimatorSet();
        //一起动
//        animatorSet.playTogether(animator1, animator2, animator3);

        //按顺序依次动，但是第二次点move按钮的时候起点不是原来的起点。。。
//        animatorSet.playSequentially(animator1, animator2, animator3);

        //属性对话框中使用最多的一种配合-->多个ObjectAnimator组合到一个AnimatorSet中形成一个完整的动画效果
        //通过play等各种方法实现更为丰富的动画效果
        animatorSet.play(animator1).with(animator2);
        animatorSet.play(animator3).after(animator1);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }
}
