package com.example.alphacare24x7

import android.os.Bundle
import android.os.Message
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    //global variable for webview
    lateinit var mainWebView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the WebView by its unique ID
        mainWebView = findViewById(R.id.mainWebView)

        //loading url in webview
        mainWebView.loadUrl("https://cosbike.in/")

        //now enable the javascript for the website
        mainWebView.settings.javaScriptEnabled = true

        //now set webview client to handle
        //on pageFinished and override the url loading
        mainWebView.webViewClient = object:WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: String?
            ): Boolean {
                if (request != null) {
                    view?.loadUrl(request)
                }
                return super.shouldOverrideUrlLoading(view, request)
            }
        }

    }


}