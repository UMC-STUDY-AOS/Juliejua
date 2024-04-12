package com.example.umc_flo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.umc_flo.databinding.FragmentAlbumBinding

//프래그먼트 클래스는 프래그먼트의 기능을 사용할 수 있는 클래스
class AlbumFragment : Fragment() {
  lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        //fragment 전환
        //백버튼을 눌렀을때 홈 화면으로 이동함
        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commitAllowingStateLoss()
        }

        //토스트 메세지
        binding.songLalacLayout.setOnClickListener {
            Toast.makeText(activity, "LILAC", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}