package com.example.royal.testscichart

import android.app.Application
import com.scichart.charting.visuals.SciChartSurface

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val key = "<LicenseContract>\n" +
                "  <Customer>dariush.fathe@gmail.com</Customer>\n" +
                "  <OrderId>Trial</OrderId>\n" +
                "  <LicenseCount>1</LicenseCount>\n" +
                "  <IsTrialLicense>true</IsTrialLicense>\n" +
                "  <SupportExpires>01/10/2019 00:00:00</SupportExpires>\n" +
                "  <ProductCode>SC-ANDROID-2D-ENTERPRISE-SRC</ProductCode>\n" +
                "  <KeyCode>fe01bf2156a0a583e3e865fe449c214b31ce379a0eff787eab279f64d5686b08a77078bdce9c89a59c831f5505ca125be1f379e336ffa4f9da515d2ae45634ad36c153e6112439fdd999df3fb70e44d44ed21f52d2a743d73fdc59ad1d230705471cb7a38c65914deed94c6931573b6322bcc75b677ca0ce57171d8632bb76d1fe65f25cbff0ecae867165dc2128ad372837bace5f9687da7b4372c5e3e0e71565febd7e17da53c9a0ba3612b8a9e165f9</KeyCode>\n" +
                "</LicenseContract>"

        SciChartSurface.setRuntimeLicenseKey(key)

    }

}