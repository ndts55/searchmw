package ndts.searchmw

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (intent?.action) {
            Intent.ACTION_SEND -> {
                if (intent.type == "text/plain") {
                    handleSendText(intent.getStringExtra(Intent.EXTRA_TEXT))
                }
            }
        }
    }

    private fun handleSendText(text: String) {
        val uri = String.format("https://www.merriam-webster.com/dictionary/%s", text)
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(uri)
        startActivity(intent)
    }

}
