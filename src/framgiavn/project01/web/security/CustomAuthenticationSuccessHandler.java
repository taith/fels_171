package framgiavn.project01.web.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 
public class CustomAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {
 
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {

		HttpSession session = request.getSession();
		
		/*Set some session variables*/
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
        session.setAttribute("email", authUser.getUsername());  
        session.setAttribute("authorities", authentication.getAuthorities());
        
        /*Set target URL to redirect*/
		String targetUrl = determineTargetUrl(authentication); 
        redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		boolean isAdmin = false;
		boolean isUser = false;
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) userDetails.getAuthorities();
		for(Iterator it = authorities.iterator(); it.hasNext();) {
			SimpleGrantedAuthority authority = (SimpleGrantedAuthority) it.next();
			if(authority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			} else if(authority.getAuthority().equals("ROLE_USER")) {
				isUser = true;
				break;
			}
		}
		
		if (isUser) {
            return "/welcome";
        } else if (isAdmin) {
            return "/admin";
        } else {
        	throw new IllegalStateException();
        }
    }
 
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
 
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
}

