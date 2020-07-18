package com.crisspian.logotrivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crisspian.logotrivia.databinding.FragmentWinBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WinFragment extends Fragment {

    FragmentWinBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public WinFragment() {
        // Required empty public constructor
    }

    public static WinFragment newInstance(String param1, String param2) {
        WinFragment fragment = new WinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWinBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        String text = getString(R.string.win_msg, mParam1);
        binding.winTv.setText(text);

        binding.winRetryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTitleFragment(mParam1);
            }
        });

        return view;
    }

    private void goToTitleFragment(String name) {
        TitleFragment titleFragment = TitleFragment.newInstance();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_fragment, titleFragment, TitleFragment.class.getSimpleName()).commit();
    }

}