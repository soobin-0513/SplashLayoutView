package com.example.splashlayoutview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bin_list_item.*
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {

    private var currentPosition = 0
    //핸들러 설정해서 ui변경하기
    val handler = Handler(Looper.getMainLooper()){
        setPage()
        true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //어댑터 생성
        view_Pager_bin.adapter =ViewPagerAdapter(getBinList())
        //방향 가로 설정
        view_Pager_bin.orientation=ViewPager2.ORIENTATION_HORIZONTAL




        //뷰페이저 넘기는 쓰레드
        val thread=Thread(PagerRunnable())
        thread.start()
    }
    //페이지 변경하기
    fun setPage(){
        if(currentPosition==3) currentPosition=0
        view_Pager_bin.setCurrentItem(currentPosition,true)
        currentPosition+=1


    }

    //Runnable 핸들러호출하기
    // 2초 마다 페이지 넘기기
    inner class PagerRunnable:Runnable{
        override fun run() {
            while(true){
                Thread.sleep(3000)
                handler.sendEmptyMessage(0)
            }
        }
    }
    // 뷰 페이저에 들어갈 아이템
    private fun getBinList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.bin1, R.drawable.bin2, R.drawable.bin3)

    }




}

