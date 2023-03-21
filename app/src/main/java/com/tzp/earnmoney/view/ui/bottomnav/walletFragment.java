package com.tzp.earnmoney.view.ui.bottomnav;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.tzp.earnmoney.databinding.FragmentWalletBinding;
public class walletFragment extends Fragment {
    private FragmentWalletBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentWalletBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}