package com.kalvineng.reflex;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.kalvineng.reflex.BuzzerPackage.Buzzer;
import com.kalvineng.reflex.ReactionPackage.ReactionDialog;
import com.kalvineng.reflex.ReactionPackage.ReactionTimes;
import com.kalvineng.reflex.StatsPackage.Statistics;

public class MainMenu extends ActionBarActivity implements ReactionDialog.NoticeDialogListener,PlayerSelectDialog.SelectDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void reactionTimes(View view) {
        DialogFragment instructionDialog = new ReactionDialog();
        instructionDialog.show(getFragmentManager(), "ReactionTimeInstructions");
    }


    public void buzzer(View view) {
        DialogFragment selectionDialog = new PlayerSelectDialog();
        selectionDialog.show(getFragmentManager(), "PlayerSelection");
    }

    public void statistics(View view) {
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);
    }

    // taken from http://developer.android.com/guide/topics/ui/dialogs.html 08/01/15
    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Intent intent = new Intent(this, ReactionTimes.class);
        startActivity(intent);
    }
    // defined by the PlayerSelectDialog.SelectDialogListener interface
    @Override
    public void onDialogPlayerSelected(DialogFragment dialog, int player) {
        Intent amount = new Intent(getApplicationContext(), Buzzer.class);
        amount.putExtra("amount", player); //send amount of players to buzzer
        Intent intent = new Intent(this, Buzzer.class);
        startActivity(amount);
    }
}
