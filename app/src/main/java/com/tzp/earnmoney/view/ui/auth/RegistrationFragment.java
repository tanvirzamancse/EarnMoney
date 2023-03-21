package com.tzp.earnmoney.view.ui.auth;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tzp.earnmoney.R;
import com.tzp.earnmoney.databinding.FragmentRegistrationBinding;

public class RegistrationFragment extends Fragment {
    private FragmentRegistrationBinding binding;
    BottomSheetBehavior bottomSheetBehavior;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(getLayoutInflater());

      //  showBottomSheetDialog();
        return binding.getRoot();
    }

   /* private void showBottomSheetDialog() {
        // get the bottom sheet view
       // LinearLayout bottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        // init the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from(binding.include.bottomSheetLayout);


        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                       // textViewBottomSheetState.setText("STATE HIDDEN");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //textViewBottomSheetState.setText("STATE EXPANDED");
                        // update toggle button text
                        bottomSheetBehavior.setPeekHeight(800,true);
                      //  toggleBottomSheet.setText("Expand BottomSheet");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                       // textViewBottomSheetState.setText("STATE COLLAPSED");
                        // update collapsed button text
                        bottomSheetBehavior.setPeekHeight(200);
                        bottomSheetBehavior.setHideable(false);
                      //  toggleBottomSheet.setText("Collapse BottomSheet");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                      //  textViewBottomSheetState.setText("STATE DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                      //  textViewBottomSheetState.setText("STATE SETTLING");
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        break;
                }
                Log.d(TAG, "onStateChanged: " + newState);
            }
            @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });


        binding.include.tvPicupLocation.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                  //  toggleBottomSheet.setText("Collapse BottomSheet");
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                   // toggleBottomSheet.setText("Expand BottomSheet");
                }
            }
        });
    }*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.registrationFragment_to_loginFragment);

            }
        });
    }


   /* private void showBottomSheetDialog() {


        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(R.layout.popup_pickup_location);



        bottomSheetDialog.setCanceledOnTouchOutside(false);

       // bottomSheetDialog.getBehavior().setPeekHeight(400);
        bottomSheetDialog.getBehavior().setMaxHeight(800);
        bottomSheetDialog.getBehavior().setHideFriction(150);
        bottomSheetDialog.getBehavior().setHideable(false);
        bottomSheetDialog.getBehavior().setDraggable(true);


        AppCompatTextView picUpLocation = bottomSheetDialog.findViewById(R.id.tv_picupLocation);
        AppCompatEditText picUpGuide = bottomSheetDialog.findViewById(R.id.et_guide);
        AppCompatButton button = bottomSheetDialog.findViewById(R.id.confirm_location);

     //  LinearLayout mBottomSheetLayout= bottomSheetDialog.findViewById(R.id.bottom_sheet_layout);


      //  BottomSheetBehavior<LinearLayout> sheetBehavior = BottomSheetBehavior.from(bottomSheetDialog);

        picUpLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               *//* if(bottomSheetDialog.getBehavior().getState() != BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetDialog.getBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    bottomSheetDialog.getBehavior().setState(BottomSheetBehavior.STATE_COLLAPSED);
                    sheetBehavior.setPeekHeight(400);
                }*//*

            }
        });

        bottomSheetDialog.show();
    }*/

}