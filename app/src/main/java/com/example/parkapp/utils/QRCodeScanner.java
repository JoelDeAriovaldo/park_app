package com.example.parkapp.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCodeScanner {

    private Activity activity;
    private QRCodeScannerListener listener;

    public QRCodeScanner(Activity activity, QRCodeScannerListener listener) {
        this.activity = activity;
        this.listener = listener;
    }

    public void initializeScanner() {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Scan a QR Code");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();
    }

    public void handleActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                listener.onQRCodeScanCancelled();
            } else {
                listener.onQRCodeScanned(result.getContents());
            }
        }
    }

    public interface QRCodeScannerListener {
        void onQRCodeScanned(String qrCodeContent);
        void onQRCodeScanCancelled();
    }
}