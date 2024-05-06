package com.example.umc_flo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc_flo.databinding.FragmentHomeBinding
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_flo.BannerFragment
import com.example.umc_flo.BannerVPAdapter

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
//        binding.homeAlbumImgIv1.setOnClickListener {
//            //replace 함수는 파란색 프레임 레이아웃을 앨범프래그먼트로 대체한다는 뜻이다
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm , AlbumFragment())
//                .commitAllowingStateLoss() //프래그먼트 전환을 위해 많이 사용, 네비바에서도 사용함
//        }
        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))

        binding.homePannelViewpagerImg.adapter=bannerAdapter
        binding.homePannelViewpagerImg.orientation=ViewPager2.ORIENTATION_HORIZONTAL

        val panelAdapter=PanelVPAdapter(this)
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_album_exp4))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_album_exp4))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_first_album_default))
        panelAdapter.addFragment(PanelFragment(R.drawable.img_album_exp4))



        binding.homePannelBackgroundIv.adapter=panelAdapter
        binding.homePannelBackgroundIv.orientation=ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }

}