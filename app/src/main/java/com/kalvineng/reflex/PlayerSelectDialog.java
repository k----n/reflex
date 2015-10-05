package com.kalvineng.reflex;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 Player Selection Dialog Fragment

 Copyright 2015 Google Inc, Kalvin Eng

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.


 Code taken from http://developer.android.com/guide/topics/ui/dialogs.html 08/01/15

 **/
public class PlayerSelectDialog extends DialogFragment {


    public PlayerSelectDialog() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.player_select)
                .setItems(R.array.players, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        mListener.onDialogPlayerSelected(PlayerSelectDialog.this, which);

                    }
                });
        return builder.create();
    }

    /* The activity that creates an instance of this dialog fragment must
    * implement this interface in order to receive event callbacks.
    * Each method passes the DialogFragment in case the host needs to query it. */
    public interface SelectDialogListener {
        public void onDialogPlayerSelected(DialogFragment dialog, int player);
    }

    // Use this instance of the interface to deliver action events
    SelectDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the SelectDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the SelectDialogListener so we can send events to the host
            mListener = (SelectDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement SelectDialogListener");
        }
    }


}
