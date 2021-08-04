package jp.wings.nikkeibp.a30countgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class GameOver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        //変数宣言【idの取得(戻るボタン)】
        val btnReplay = findViewById<Button>(R.id.btnReplay)

        //REPLAYボタンを押下するように促す【お知らせ】
        Toast.makeText(this,"REPLAYボタンを押すと再戦！！",Toast.LENGTH_LONG).show()

        //ボタン押下時の処理【戻るボタン】
        btnReplay.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}