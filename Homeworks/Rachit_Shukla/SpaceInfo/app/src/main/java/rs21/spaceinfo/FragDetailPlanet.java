package rs21.spaceinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FragDetailPlanet extends Fragment{
    public static FragDetailPlanet newInstance(Planets a) {

        Bundle args = new Bundle();
        args.putParcelable("Current", a);
        FragDetailPlanet fragment = new FragDetailPlanet();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        Planets data = (Planets) bundle.getParcelable("Current");
        View view = inflater.inflate(R.layout.frag_detail, container, false);
        WebView v = view.findViewById(R.id.wiki);
        v.getSettings().setJavaScriptEnabled(true);
        v.getSettings().setAppCacheEnabled(true);
        v.loadUrl(data.getUrl());
        v.setWebViewClient(new WebViewClient());
        return view;
    }
}
