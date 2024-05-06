package com.example.umc_flo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_flo.databinding.ActivitySongBinding
import java.util.Timer

//AppCompatActivity은 안드로이드에서 AppComPat을 사용할 수 있도록 만든 기능임
class SongActivity : AppCompatActivity() {

    lateinit var binding: ActivitySongBinding
    lateinit var song: Song
    lateinit var timer: Timer

    //액티비티 실행시 처음 실행되는 함수 -> onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate는 xml에 표기된 레이아웃들을 메모리에 연결하는 것
        binding = ActivitySongBinding.inflate(layoutInflater)
        //binding.root에서 root는 연결된 액티비티의 최상단뷰를 가리킴 -> 액티비티의 모든 뷰를 사용하겠다는 뜻
        setContentView(binding.root)

        initSong()
        setPlayer(song)

        //액티비티 종료하기
        binding.songDownIb.setOnClickListener {
            //메인액티비티로 돌아감
            finish()
        }
        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(true)
        }
        //인텐트에 값 있는지 확인
        if (intent.hasExtra("title") && intent.hasExtra("singer")) {
            //값 있으면 텍스트 값을 바꿈
            binding.songMusicTitleTv.text = intent.getStringExtra("title")!!
            binding.songSingerNameTv.text = intent.getStringExtra("singer")!!

        }
    }

    private fun initSong() {
        if (intent.hasExtra("title") && intent.hasExtra("singer")) {
            song = Song(
                intent.getStringExtra("title")!!,
                intent.getStringExtra("singer")!!,
                intent.getIntExtra("second", 0),
                intent.getIntExtra("playTime", 0),
                intent.getBooleanExtra("isPlaying", false)

            )
        }
        startTimer()
    }

    private fun setPlayer(song: Song) {
        binding.songMusicTitleTv.text = intent.getStringExtra("title")!!
        binding.songSingerNameTv.text = intent.getStringExtra("singer")!!
        binding.songStartTimeTv.text =
            String.format("%02d:%02d", song.second / 60, song.second % 60)
        binding.songEndTimeTv.text =
            String.format("%02d:%02d", song.playTime / 60, song.playTime % 60)
        binding.songProgressbarView.progress = (song.second * 1000 / song.playTime)

        setPlayerStatus(song.isPlaying)

    }


    //SongActivity 이미지 변환
    fun setPlayerStatus(isPlaying: Boolean) {
        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        } else {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }

    private fun startTimer() {
        timer = Timer(song.playTime, song.isPlaying)
        timer.start()
    }

    inner class Timer(private val playTime: Int, var isPlaying: Boolean = true) : Thread() {
        private var second: Int = 0
        private var mills: Float = 0f

        override fun run() {
            super.run()
            while (true) {
                if (second >= playTime) {
                    break
                }
                if (isPlaying) {
                    sleep(50)
                    mills += 50

                    runOnUiThread {
                        binding.songProgressbarView.progress = ((mills / playTime) * 100).toInt()
                    }
                    if (mills % 1000 == 0f) {
                        runOnUiThread {
                            binding.songStartTimeTv.text =
                                String.format("%02d:%02d", second / 60, second % 60)
                        }
                        second++
                    }

                }

            }
        }
    }

}