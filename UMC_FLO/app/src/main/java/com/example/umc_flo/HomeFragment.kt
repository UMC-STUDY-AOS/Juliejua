package com.example.umc_flo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc_flo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //fragment 전환
        //activity에서는 startActivity를 사용했지만 fragment에서는 다른 방식 사용
        binding.homeAlbumImgIv1.setOnClickListener {
            //replace 함수는 파란색 프레임 레이아웃을 앨범프래그먼트로 대체한다는 뜻이다
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm , AlbumFragment())
                .commitAllowingStateLoss() //프래그먼트 전환을 위해 많이 사용, 네비바에서도 사용함
        }
        return binding.root
    }

}