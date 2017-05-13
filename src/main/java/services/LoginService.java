package services;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import services.interfaces.ILoginService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alisa on 5/13/2017.
 */
@Component
public class LoginService implements ILoginService {

    @Override
    public Authentication getAuthenticationToken() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Username: ");
            String userName = in.readLine().trim();
            System.out.print("Password: ");
            String password = in.readLine().trim();
            return new UsernamePasswordAuthenticationToken(userName, password);
        } catch (IOException ex) {
            return null;
        }
    }
}
