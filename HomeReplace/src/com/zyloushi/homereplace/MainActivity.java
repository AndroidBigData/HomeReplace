package com.zyloushi.homereplace;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {
	private buynewFragment buynew;
	private saveFragment save;
	private mineFragment mine;
	private chatFragment chat;
	private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}

	private void initView() {
		// TODO Auto-generated method stub
		fragmentManager = getSupportFragmentManager();
		buynew=new buynewFragment();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, buynew).commit();
        radioGroup = ((RadioGroup) findViewById(R.id.rg_content));
	}
	
	private void initData() {
		// TODO Auto-generated method stub
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.buynew:
                        replaceFragment(R.id.buynew);
                        break;
                    case R.id.save:
                        replaceFragment(R.id.save);
                        break;
                    case R.id.mine:
                        replaceFragment(R.id.mine);
                        break;
                    case R.id.chat:
                        replaceFragment(R.id.chat);
                        break;
                }
            }
        });
	}
	
	private void replaceFragment(int checkedId) {
        transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (checkedId) {
            case R.id.buynew:
                if (buynew != null) {
                    transaction.show(buynew);
                } else {
                    buynew = new buynewFragment();
                    transaction.add(R.id.fragment, buynew);
                }
                break;
            case R.id.save:
                if (save != null) {
                    transaction.show(save);
                } else {
                    save = new saveFragment();
                    transaction.add(R.id.fragment, save);
                }
                break;
            case R.id.mine:
                if (mine != null) {
                    transaction.show(mine);
                } else {
                    mine = new mineFragment();
                    transaction.add(R.id.fragment, mine);
                }
                break;
            case R.id.chat:
                if (chat != null) {
                    transaction.show(chat);
                } else {
                    chat = new chatFragment();
                    transaction.add(R.id.fragment, chat);
                }
                break;
        }
        transaction.commit();
    }
	
	private void hideFragment(FragmentTransaction transaction) {
        if (buynew != null) {
            transaction.hide(buynew);
        }
        if (save != null) {
            transaction.hide(save);
        }
        if (mine != null) {
            transaction.hide(mine);
        }
        if (chat != null) {
            transaction.hide(chat);
        }

    }
}
