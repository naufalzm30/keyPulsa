package com.example.keypulsa;


import android.content.DialogInterface;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;



import org.w3c.dom.Text;

public class keyPulsa extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private KeyboardView kv;
    private Keyboard keyboard,nominal;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public View onCreateInputView() {

        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.num);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);

        return kv;

    }


    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {


    }



    @Override
    public void onKey (int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        CharSequence selectedText = ic.getSelectedText(0);

        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                if (TextUtils.isEmpty(selectedText)) {
                    ic.deleteSurroundingText(1, 0);
                } else {
                    ic.commitText("", 1);
                }
                break;
            case Keyboard.KEYCODE_DONE:

                nominal = new Keyboard(this,R.xml.nominal);
                kv.setKeyboard(nominal);
                ic.setSelection(0,0);
                break;
            case 3:

                break;
            case 66:
                kv.setKeyboard(keyboard);
                break;
            default:

            char code = (char) primaryCode;
            ic.commitText(String.valueOf(code), 0);
        }


    }


    @Override
    public void onText(CharSequence text) {
        InputConnection ic = getCurrentInputConnection();
        ic.commitText(text, 0);

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }


}
