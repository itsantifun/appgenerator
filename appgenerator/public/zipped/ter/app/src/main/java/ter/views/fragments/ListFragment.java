package ter.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ter.R;
import ter.databinding.FragmentListBinding;
import ter.models.User;
import ter.utils.DummyDataFactory;
import ter.viewmodels.UserListViewModel;
import ter.views.adapters.ListAdapter;

/**
 * Created by bukhoriaqid on 11/27/16.
 */

public class ListFragment extends BaseFragment
{
    FragmentListBinding mBinding;
    List<User>          mUsers;


    public ListFragment ()
    {
        setArguments(new Bundle());
        mUsers = DummyDataFactory.createDummyUsers();
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState)
    {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        mBinding.setUsers(new UserListViewModel());

        mBinding.rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rvContent.setAdapter(new ListAdapter(mUsers));
        return mBinding.getRoot();
    }

    @Override
    void initUI ()
    {

    }

    @Override
    void initEvent ()
    {

    }
}
