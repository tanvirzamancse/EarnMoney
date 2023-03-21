package com.tzp.earnmoney.view.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.tzp.earnmoney.R;
import com.tzp.earnmoney.databinding.FragmentLoginBinding;
import com.tzp.earnmoney.service.model.auth.LoginResponse;
import com.tzp.earnmoney.viewmodel.LoginViewModel;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    private LoginViewModel viewModel = null;
   // private String Email = null, Password = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //.appComponent.inject(this);
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding.setLogin(viewModel);
        ClickEvent();
        return binding.getRoot();
    }

    private void ClickEvent() {

        binding.butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              if (dataValidation()){
                  doLogin();
              }


            }
        });

        binding.butRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.loginFragment_to_registrationFragment);
            }
        });
        binding.tvForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void doLogin() {

        viewModel.getLoginViewModel().observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {

                if (loginResponse != null) {

                    //   Toast.makeText(requireContext(), "Response", Toast.LENGTH_SHORT).show();

                    if (loginResponse.getSuccess()) {
                        Toast.makeText(requireContext(), "" + loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        binding.animationView.setVisibility(View.INVISIBLE);
                        Navigation.findNavController(binding.getRoot()).navigate(R.id.loginFragment_to_homeFragment);

                    } else {

                        Toast.makeText(getContext(), "" + loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        binding.animationView.setVisibility(View.INVISIBLE);
                    }

                } else {
                    // Toast.makeText(requireContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    binding.animationView.setVisibility(View.INVISIBLE);

                }

            }
        });

    }

    private boolean dataValidation() {

        int status = viewModel.verificationOfRequiredData();

        if(status == 1)//user name validation error
        {
            binding.etEmail.setError("Empty username not allowed");//set error message
            binding.etEmail.requestFocus();//set focus

            return false;
        }else if(status == 2)//password validation error
        {
            binding.etPass.setError("Empty password not allowed");//set error message
            binding.etPass.requestFocus();//set focus
            return false;
        }

        return true;
    }
}