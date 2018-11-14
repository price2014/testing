package perricesoftware.com.sqlite;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button BnSave,BnView,BnDelete,BnUpdate;

    OnDbOpListener onDbOpListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListener {

        public void dBOpPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        BnSave = view.findViewById(R.id.bn_add_contact);
        BnSave.setOnClickListener(this);
        BnView = view.findViewById(R.id.bn_view_contact);
        BnView.setOnClickListener(this);
        BnUpdate = view.findViewById(R.id.bn_update_contact);
        BnUpdate.setOnClickListener(this);

        BnDelete = view.findViewById(R.id.bn_delete_contact);
        BnDelete.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.bn_add_contact:
                onDbOpListener.dBOpPerformed(0);
                break;

            case R.id.bn_view_contact:
                onDbOpListener.dBOpPerformed(1);
                break;

            case R.id.bn_update_contact:
                onDbOpListener.dBOpPerformed(2);
                break;

            case R.id.bn_delete_contact:
                onDbOpListener.dBOpPerformed(3);
                break;

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try{
            onDbOpListener = (OnDbOpListener) activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+" must implement the interface method...");
        }
    }
}
