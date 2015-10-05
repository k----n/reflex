package com.kalvineng.reflex.BuzzerPackage;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kalvineng.reflex.R;

/**
 * Code taken from http://developer.android.com/guide/topics/ui/dialogs.html 08/01/15
 */
public class BuzzerPressDialog extends DialogFragment {


    public BuzzerPressDialog() {
        // Required empty public constructor
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        String message = args.getString("message", ""); // retrieves message from Activity

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message)
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Okay
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
