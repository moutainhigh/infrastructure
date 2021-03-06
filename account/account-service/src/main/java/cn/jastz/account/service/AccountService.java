package cn.jastz.account.service;

import cn.jastz.account.entity.Account;
import cn.jastz.account.entity.AccountPassword;
import cn.jastz.account.entity.AccountSocialRef;
import cn.jastz.account.mapper.AccountMapper;
import cn.jastz.account.mapper.AccountPasswordMapper;
import cn.jastz.account.mapper.AccountSocialRefMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhiwen
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountSocialRefMapper accountSocialRefMapper;

    @Autowired
    private AccountPasswordMapper accountPasswordMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account selectAccountByUsernameAndSocialAndAppId(String username, String social, String appId) {
        AccountSocialRef accountSocialRef = accountSocialRefMapper.selectByUserNameAndSocialAndAppId(username, social, appId);
        if (accountSocialRef == null) {
            return null;
        }
        int accountId = accountSocialRef.getAccountId();
        Account account = accountMapper.selectByPrimaryKey(accountId);
        AccountPassword accountPassword = accountPasswordMapper.selectByPrimaryKey(accountId);
        account.setAccountPassword(accountPassword);
        return account;
    }

    public Account selectAccountByUsernameAndAppId(String username, String appId) {
        AccountSocialRef accountSocialRef = accountSocialRefMapper.selectByUserNameAndAppId(username, appId);
        if (accountSocialRef == null) {
            return null;
        }
        int accountId = accountSocialRef.getAccountId();
        Account account = accountMapper.selectByPrimaryKey(accountId);
        AccountPassword accountPassword = accountPasswordMapper.selectByPrimaryKey(accountId);
        account.setAccountPassword(accountPassword);
        return account;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public int saveAccount(Account account, AccountSocialRef accountSocialRef, String password) {
        if (StringUtils.isEmpty(password)) {
            password = "123456";
        }
        int count = accountMapper.insert(account);
        accountSocialRef.setAccountId(account.getAccountId());
        accountSocialRefMapper.insert(accountSocialRef);
        AccountPassword accountPassword = new AccountPassword();
        accountPassword.setAccountId(account.getAccountId());
        accountPassword.setAccountPassword(passwordEncoder.encode(password));
        accountPasswordMapper.insert(accountPassword);
        return count;
    }

    public Account queryByAccountId(int accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    public Account queryByAccountByAccount(String accountName) {
        return accountMapper.selectByAccount(accountName);
    }

    /**
     * 绑定社交账号
     *
     * @param accountSocialRef
     * @return
     */
    public int saveAccountSocialRef(AccountSocialRef accountSocialRef) {
        return accountSocialRefMapper.insert(accountSocialRef);
    }
}
