package cn.jastz.social;

import cn.jastz.account.client.AccountClient;
import cn.jastz.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author jast
 */
public class MySignInAdapter implements SignInAdapter {

    @Autowired
    private AccountClient accountClient;

    public MySignInAdapter() {
        System.out.println("MySignInAdapter init");
    }

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        if (request instanceof ServletWebRequest) {
            HttpServletRequest httpServletRequest = ((ServletWebRequest) request).getRequest();
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("currentAccountId", userId);
            Account account = accountClient.queryAccountByAccountId(Integer.parseInt(userId));
            session.setAttribute("username", account.getAccountName());
        }
        return "/";
    }
}
