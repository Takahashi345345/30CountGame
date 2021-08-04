package jp.wings.nikkeibp.a30countgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    //変数宣言【カウントの初期値】
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //変数宣言【idの取得(1～3の加算ボタン)】
        val btnPlus1 = findViewById<Button>(R.id.btnPlus1)
        val btnPlus2 = findViewById<Button>(R.id.btnPlus2)
        val btnPlus3 = findViewById<Button>(R.id.btnPlus3)

        //ボタン押下時の処理【1ボタン】
        btnPlus1.setOnClickListener {

            //カウントに1加算
            count++

            //加算後の条件処理
            if (count >= 30){

                //画面遷移
                screenTransition()
            }else{

                //カウント変更
                tvChange()

                //ずる防止メソッド
                pcNotice()
            }
        }

        //ボタン押下時の処理【2ボタン】
        btnPlus2.setOnClickListener {

            //カウントに2加算
            count += 2

            //加算後の条件処理
            if (count >= 30){

                //画面遷移
                screenTransition()
            }else{

                //カウント変更
                tvChange()

                //ずる防止メソッド
                pcNotice()
            }
        }

        //ボタン押下時の処理【3ボタン】
        btnPlus3.setOnClickListener {

            //カウントに3加算
            count += 3

            //加算後の条件処理
            if (count >= 30){

                //画面遷移
                screenTransition()
            }else{

                //カウント変更
                tvChange()

                //ずる防止メソッド
                pcNotice()
            }
        }
    }

    //画面遷移メソッド【MainActivity.ktを終了すると同時にGameOver.ktに画面遷移】
    private fun screenTransition(){
        val intent = Intent(this,GameOver::class.java)
        startActivity(intent)
        finish()
    }

    //カウント変更メソッド【押下した加算ボタンに応じてテキストに反映】
    private fun tvChange(){
        val tvCount = findViewById<TextView>(R.id.tvCount)
        tvCount.text = count.toString()
    }

    //ずる防止メソッド【プレイヤー交代(お知らせ)】
    private  fun pcNotice(){
        AlertDialog.Builder(this)
            .setTitle("PLAYER CHANGE!!")
            .setMessage("次のプレイヤーに代わったら\nOKボタンを押下してください。")
            .setPositiveButton("OK",null)
            .show()
    }
}