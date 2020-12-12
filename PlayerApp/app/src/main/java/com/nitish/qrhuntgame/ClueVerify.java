package com.nitish.qrhuntgame;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class ClueVerify extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new FragClue()).commit();
        }

    }
}
