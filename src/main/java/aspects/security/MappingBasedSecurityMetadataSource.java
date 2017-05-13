package aspects.security;

/**
 * Created by Alisa on 5/14/2017.
 */
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.util.PatternMatchUtils;

public class MappingBasedSecurityMetadataSource implements SecurityMetadataSource {

    private Map<String, String> mapping;

    public List<ConfigAttribute> getAttributes(Object jp) {
        String methodName = ((JoinPoint) jp).getSignature().getName();
        for (String pattern : mapping.keySet()) {
            if (PatternMatchUtils.simpleMatch(pattern, methodName)) {
                String role = mapping.get(pattern);
                return SecurityConfig.createList(role);
            }
        }
        throw new IllegalArgumentException("Unknown mapping for " + methodName);
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class clazz) {
        return clazz.isAssignableFrom(JoinPoint.class);
    }

    public void setRoleMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
