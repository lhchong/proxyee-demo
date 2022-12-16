package com.nogroup.proxyeedemo;

import com.github.monkeywie.proxyee.server.HttpProxyServer;
import com.github.monkeywie.proxyee.server.HttpProxyServerConfig;
import com.github.monkeywie.proxyee.server.auth.BasicHttpProxyAuthenticationProvider;
import com.github.monkeywie.proxyee.server.auth.model.BasicHttpToken;

public class ProxyeeDemoApplication {

    public static void main(String[] args) {
        String username = "lhchong";
        String password = "123456";

        HttpProxyServerConfig config = new HttpProxyServerConfig();
        config.setAuthenticationProvider(new BasicHttpProxyAuthenticationProvider() {
            @Override
            protected BasicHttpToken authenticate(String usr, String pwd) {
                if (username.equals(usr) && password.equals(pwd)) {
                    return new BasicHttpToken(usr, pwd);
                }
                return null;
            }
        });
        System.out.println("proxy server started on port 9999");

        new HttpProxyServer()
                .serverConfig(config)
                .start(9999);
    }

}
