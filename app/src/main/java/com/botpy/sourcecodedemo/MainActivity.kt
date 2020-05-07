package com.botpy.sourcecodedemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.widget.TextView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = text

        var kotlinDemo = KotlinDemo.getInstacne().name
        output(textView)
        webView.getSettings().setJavaScriptEnabled(true)
        webView.getSettings().setDomStorageEnabled(true)
        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW)
        webView.loadDataWithBaseURL(null,"<html><style>table{width: 100%;font-size: 11px;" +
                "color:#9d9d9d;text-align: center;border-spacing: 0;border-collapse: collapse;border: #eae9e6 solid 1px;}tablethead{background-color: #f6f6f6;}" +
                " table th,table td {padding-top: 10px;padding-bottom: 10px;border:#eae9e6 solid 1px}</style><html><body><table><thead><tr></tr><tr><td>                    DAA          </td></tr><tr><td>序号</td><td>产品名称</td><td>是否必选标识</td><td>产品类别</td><td>产品单价</td></tr></thead><tbody><tr><td>  1    </td><td><a >车身防锈检测服务包</a></td><td>    是          </td><td>  1    </td><td>  15    </td></tr><tr><td>  2    </td><td><a >车辆体检服务包</a></td><td>    是          </td><td>  1    </td><td>  150    </td></tr><tr><td>  3    </td><td><a >协办检车服务包</a></td><td>    是          </td><td>  1    </td><td>  0    </td></tr></tbody></table><table><thead><tr><td>                    DZA          </td></tr><tr><td>序号</td><td>产品名称</td><td>是否必选标识</td><td>产品类别</td><td>产品单价</td></tr></thead><tbody><tr><td>  1    </td><td><a >车身防锈检测服务包</a></td><td>    否          </td><td>  1    </td><td>  15    </td></tr><tr><td>  2    </td><td><a >协办检车服务包</a></td><td>    否          </td><td>  1    </td><td>  0    </td></tr><tr><td>  3    </td><td><a >车辆体检服务包</a>" +
                "</td><td>    否          </td><td>  1    </td><td>  150    </td></tr></tbody></table></body> </html></html>", "text/html","utf-8", null)
        modeArray()
        modeIntArray()
        modeList()
    }

    private fun output(textView: TextView?) {
        Log.d(TAG, "textView: $String" + textView?.id)
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    private fun modeArray(): Long {
        var startTime = System.currentTimeMillis();
        val arry: Array<Int> = Array(10000, init = {i -> i + 1})
        var sum = 0L
        for(i in arry) {
            sum += i
        }
        Log.d(TAG, "array time: ${System.currentTimeMillis() - startTime}")
        return sum / 10000
    }

    private fun modeIntArray(): Long {
        var startTime = System.currentTimeMillis();
        val intArray = IntArray(10000, init = { i -> i + 1})
        var sum = 0L
        for(i in intArray) {
            sum += i
        }
        Log.d(TAG, "IntArray time: ${System.currentTimeMillis() - startTime}")
        return sum / 10000
    }

    private fun modeList(): Long {
        var startTime = System.currentTimeMillis();
        val list = List(10000, init = { i -> i + 1})
        var sum = 0L
        for(i in list) {
            sum += i
        }
        Log.d(TAG, "List time: ${System.currentTimeMillis() - startTime}")
        return sum / 10000
    }
}

