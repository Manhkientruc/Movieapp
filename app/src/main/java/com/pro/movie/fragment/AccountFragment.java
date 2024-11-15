package com.pro.movie.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.pro.movie.R;
import com.pro.movie.activity.ChangePasswordActivity;
import com.pro.movie.activity.SignInActivity;
import com.pro.movie.prefs.DataStoreManager;
import com.pro.movie.utils.GlobalFunction;

public class AccountFragment extends Fragment {

    private View mView;
    private TextView tvEmail;
    private LinearLayout layoutChangePassword;
    private LinearLayout layoutSignOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_account, container, false);

        initUi();
        initListener();

        return mView;
    }

    private void initUi() {
        tvEmail = mView.findViewById(R.id.tv_email);
        layoutChangePassword = mView.findViewById(R.id.layout_change_password);
        layoutSignOut = mView.findViewById(R.id.layout_sign_out);
    }

    private void initListener() {
        tvEmail.setText(DataStoreManager.getUser().getEmail());
        layoutSignOut.setOnClickListener(v -> onClickSignOut());
        layoutChangePassword.setOnClickListener(v -> onClickChangePassword());
    }

    private void onClickChangePassword() {
        GlobalFunction.startActivity(getActivity(), ChangePasswordActivity.class);
    }

    private void onClickSignOut() {
        if (getActivity() == null) {
            return;
        }
        FirebaseAuth.getInstance().signOut();
        DataStoreManager.setUser(null);
        GlobalFunction.startActivity(getActivity(), SignInActivity.class);
        getActivity().finishAffinity();
    }
}
