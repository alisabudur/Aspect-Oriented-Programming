package services.interfaces;

import org.springframework.security.core.Authentication;

/**
 * Created by Alisa on 5/13/2017.
 */
public interface ILoginService {
    Authentication getAuthenticationToken();
}
