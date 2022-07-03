package com.example.splashlayoutview

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*


//AppCompatActivity()->액티비티 관리하는 클래스 상속
class SplashActivity : AppCompatActivity() {
    //화면3초동안 보여주기
   // val Splash_viewTime: Long = 3000

     //val TAG:String ="로그"
    // 뷰가 생성되었을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //화면을 출력하는 xml 명시하기
        setContentView(R.layout.activity_splash)

        //R.layout.activity_splash
        //애니메이션 인스턴스 생성하기
        var fadeOutAnimation = AnimationUtils.loadAnimation(this,R.anim.fade_out)
        splash_title.startAnimation(fadeOutAnimation)
        textView.startAnimation(fadeOutAnimation)
        //startAnimation(fadeOutAnimation)

        //일정시간 지난 후에 실행하는 코드
        Handler(Looper.getMainLooper()).postDelayed({
            //일정시간 지난 후 메인액티비티 실행!
            val intent= Intent( this,MainActivity::class.java)
            startActivity(intent)
            //애니메이션 추가
            //(다음화면에 실행할 애니메이션, 현재화면에 실행할 애니메이션)
           //overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
            // 이전 키를 눌렀을 때 스플래스 스크린 화면으로 이동을 방지하기 위해
            // 이동한 다음 사용안함으로 finish 처리
            finish()
        }, 3000)

    }



}

