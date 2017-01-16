package deka.crepes.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import deka.crepes.R;
import deka.crepes.databinding.FragmentListBinding;
import deka.crepes.models.User;
import deka.crepes.utils.DummyDataFactory;
import deka.crepes.viewmodels.UserListViewModel;
import deka.crepes.views.adapters.ListAdapter;

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
